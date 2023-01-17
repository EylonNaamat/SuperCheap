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
        Log.d("test_comment", "dont work1");

        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("test_comment", "dont work1");
                view.promptMsg("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d("test_comment", "4");
                if(response.isSuccessful())
                {
                    Log.d("test_comment", "5");
                    ResponseBody responseBody = response.body();
                    try{
                        Log.d("test_comment", "6");
                        JSONObject obj = new JSONObject(responseBody.string());
                        Log.d("test_comment", "7");
                        Log.d("test_comment", obj.toString());
                        if(!obj.getString("ans").equals("success")){
                            Log.d("test_comment", "enter ans");
                            view.promptMsg("something went wrong with the calculation");
                            view.failToDisplay();
                        }else{
                            Log.d("test_comment", "111");
                            JSONArray keys = obj.names ();
                            size = keys.length()-1;
                            Log.d("test_comment", keys.toString());
                            for (int i = 0; i < keys.length(); i++) {
                                Log.d("test_comment", "222");
                                String key = keys.getString (i); // Here's your key
                                Log.d("test_comment", key);
                                if(!key.equals("ans")){
                                    Log.d("test_comment", "333");
                                    JSONObject value = obj.getJSONObject(key); // Here's your value
                                    Log.d("test_comment", value.toString());
                                    String grade = value.getString("grade");
                                    Log.d("test_comment", grade);
                                    String review = value.getString("review");
                                    Log.d("test_comment", review);
                                    String username = value.getString("user_username");
                                    Log.d("test_comment", username);

                                    addCommentToList(grade, review, username);

                                    Log.d("test_comment", "444");
                                }
                            }
                        }
                        Log.d("test_comment", "8");
                        Log.d("test_comment", "81");
                    }catch (Exception e){
                        Log.d("test_comment", "dont work3");
                        view.promptMsg("something went wrong");
                        Log.d("test_comment", e.toString());
                    }
                    Log.d("test_comment", "work1");
                    Log.d("test_comment", "work");
                }
                else
                {
                    Log.d("test_comment", "dont work2");
                    view.promptMsg("error in getting response");
                }
            }
        });
    }

    public void addCommentToList(String grade, String review, String username){
        CommentDisplay new_comment = new CommentDisplay(grade, review, username);
        this.comments.add(new_comment);
        if(this.comments.size() == this.size){
            Log.d("test_comment", "enter sort");
            // after filling the array list to be displayed in view, we first sort it and then sending it to the view
            Log.d("test_comment", this.comments.toString());
            view.showComments(this.comments);
            Log.d("test_comment", "display");
        }
    }

}
