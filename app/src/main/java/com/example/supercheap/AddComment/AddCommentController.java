package com.example.supercheap.AddComment;

import androidx.annotation.NonNull;

import com.example.supercheap.Classes.Comment;
import com.example.supercheap.Classes.User;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AddCommentController {
    private AddCommentActivity my_view;
    private AddCommentModel my_model;
    private OkHttpClient client;

    public AddCommentController(AddCommentActivity my_view) {
        this.my_view = my_view;
        this.client = new OkHttpClient();
        this.my_model = new AddCommentModel(this,my_view);
    }
    //send it to the model for check the ditails if good ar not
    public void sendComment( String super_name,String super_city,String grade,String review)
    {
        my_model.checkgrade(super_name,super_city,grade,review);
    }
   // send the function to the bl and ask it to insert the comment
    public void insertComment(Comment my_comment)
    {
        String url = "http://10.0.2.2:5000/addcomment?id_comment=" + my_comment.getId_comment()
                + "&super_name=" + my_comment.getSuper_name()+ "&super_city=" + my_comment.getSuper_city()+ "&user_username=" + my_comment.getUser_username()
                + "&grade=" + my_comment.getGrade() + "&review=" + my_comment.getReview();

        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                my_view.throwNote("error in failure add comment");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful())
                {
                    ResponseBody responseBody = response.body();
                    try{
                        JSONObject obj = new JSONObject(responseBody.string());
                        if(obj.getString("ans").equals("fail")){
                            my_view.throwNote("fail find the super or city");
                        }
                        else
                        {
                            my_view.sended_rest();
                        }
                    }catch (Exception e){
                        my_view.throwNote("error fail find the super or city");
                    }
                }
                else
                {
                    my_view.throwNote("error in connect to server");
                }
            }
        });
    }
}
