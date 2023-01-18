package com.example.supercheap.MySuper;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.supercheap.Classes.User;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MySuperController {
    private MySuperActivity my_view;
    private MySuperModel my_modle;
    private OkHttpClient client;


    public MySuperController(MySuperActivity temp_view)
    {
        this.my_view = temp_view;
        this.my_modle = new MySuperModel(this,my_view);
        this.client = new OkHttpClient();

    }

    public void throwNote(String content)
    {
        my_view.throwNote(content);
    }
    //get super details and send it beck to view
    public void checkSuperDetails()
    {

        String url = "http://10.0.2.2:5000/mysuper/getsuper?Super_Id=" + my_view.user.getSuper_id();
        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                my_view.throwNote("error in failure my super");
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
                            my_view.throwNote("fail find super");
                        }
                        else
                        {
                            my_view.setSuperName(obj.getString("super_name"));
                            my_view.setSuperCity(obj.getString("super_city"));
                        }
                    }catch (Exception e){
                        my_view.throwNote("error in getting ans jsom");
                    }
                }
                else
                {
                    my_view.throwNote("error in getting response");
                }
            }
        });

    }
    //send to the model the details for check the format good
    public void updateUser(String super_name, String super_city)
    {
        my_modle.checkSuperDetails(super_name,super_city,this.my_view.user);
    }
    //send the details to the controler
    public void updateSuper(String super_name, String super_city)
    {
        String url = "http://10.0.2.2:5000/mysuper/setsuper?Super_Id=" + my_view.user.getSuper_id() + "&super_name=" + super_name +"&super_city=" + super_city;
        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                my_view.throwNote("error in failure my super");
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
                            my_view.throwNote("fail change super");
                        }
                        else
                        {
                            my_view.setSuperName(obj.getString("super_name"));
                            my_view.setSuperCity(obj.getString("super_city"));
                            my_view.throwNote("super change seccsful");
                        }
                    }catch (Exception e){
                        my_view.throwNote("error in getting ans jsom");
                    }
                }
                else
                {
                    my_view.throwNote("error in getting response");
                }
            }
        });
    }
}
