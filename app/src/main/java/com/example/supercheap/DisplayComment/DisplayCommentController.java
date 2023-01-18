package com.example.supercheap.DisplayComment;


import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DisplayCommentController {
    private DisplayCommentModel model;
    private DisplayCommentView view;
    private OkHttpClient client;
    private ArrayList<CommentDisplay> comments;
    private int size;


    public DisplayCommentController(DisplayCommentView view) {
        this.model = new DisplayCommentModel(this, view);
        this.view = view;
        this.client = new OkHttpClient();
        this.size = 0;
        this.comments = new ArrayList<>();
    }

    public DisplayCommentModel getModel() {
        return model;
    }

    public void setModel(DisplayCommentModel model) {
        this.model = model;
    }

    public DisplayCommentView getView() {
        return view;
    }

    public void setView(DisplayCommentView view) {
        this.view = view;
    }

    public void init(String super_name, String super_city){
        boolean is_valid = this.model.checkInfo(super_name, super_city);
        if(is_valid){
            super_name = this.model.lowerCase(super_name);
            super_city = this.model.lowerCase(super_city);
            sendInfo(super_name, super_city);
        }else{
            this.view.promptMsg("data isnt valid");
        }
    }

    public void sendInfo(String super_name, String super_city){
        String url = "http://10.0.2.2:5000/displaycomment?super_name=" + super_name
                + "&super_city=" + super_city;

        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                view.promptMsg("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful())
                {
                    ResponseBody responseBody = response.body();
                    try{
                        JSONObject obj = new JSONObject(responseBody.string());
                        if(!obj.getString("ans").equals("success")){
                            view.promptMsg("there are no comments");
                            view.failToDisplay();
                        }else{
                            JSONArray keys = obj.names ();
                            size = keys.length()-1;
                            for (int i = 0; i < keys.length(); i++) {
                                String key = keys.getString (i); // Here's your key
                                if(!key.equals("ans")){
                                    JSONObject value = obj.getJSONObject(key); // Here's your value
                                    String grade = value.getString("grade");
                                    String review = value.getString("review");
                                    String username = value.getString("user_username");

                                    addCommentToList(grade, review, username);
                                }
                            }
                        }
                    }catch (Exception e){
                        view.promptMsg("something went wrong");
                    }
                }
                else
                {
                    view.promptMsg("error in getting response");
                }
            }
        });
    }

    public void addCommentToList(String grade, String review, String username){
        CommentDisplay new_comment = new CommentDisplay(grade, review, username);
        this.comments.add(new_comment);
        if(this.comments.size() == this.size){
            view.showComments(this.comments);
        }
    }

}
