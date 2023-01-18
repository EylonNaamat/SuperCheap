package com.example.supercheap.HomePage;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.supercheap.AddComment.AddCommentActivity;
import com.example.supercheap.AddComment.AddCommentModel;
import com.example.supercheap.Classes.User;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HomePageController {
    private HomePageActivity my_view;
    private HomePageModel my_model;
    private OkHttpClient client;

    public HomePageController(HomePageActivity my_view) {
        this.my_view = my_view;
        this.client = new OkHttpClient();
        this.my_model = new HomePageModel(this,my_view);
    }
    //check if there is new comments to the super if we have it send the ans to the mudle and it will
    //make the text for the notifiction
    public void checkNotifiction(String super_ID){
        String url = "http://10.0.2.2:5000/getnewcomments?super_ID=" + super_ID;
        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                my_view.throwNote("error in failure home page");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful())
                {
                    ResponseBody responseBody = response.body();
                    try{
                        JSONObject obj = new JSONObject(responseBody.string());
                        my_model.createMassage(obj);
                    }catch (Exception e){
                        my_view.throwNote("error in getting ans jsom home page");
                    }
                }
                else
                {
                    my_view.throwNote("error in getting response home page");
                }
            }
        });
    }
}
