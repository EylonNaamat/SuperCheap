package com.example.supercheap.SignIn;

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

public class ControllerSignin {
    private SigninActivity my_view;
    private ModelSignin my_model;
    private OkHttpClient client;

    public ControllerSignin(SigninActivity view)
    {
        this.my_model = new ModelSignin(this, view);
        this.my_view = view;
        this.client = new OkHttpClient();
    }


    public void tryLogin(String username, String password)
    {
        my_model.DoLogIN(username,password);
    }

    public void doLogin(String username, String password)
    {
        String url = "http://10.0.2.2:5000/signin?username=" + username + "&password=" + password;
        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("test_signup", "dont work1");
                my_view.throwNote("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful())
                {
                    ResponseBody responseBody = response.body();
                    try{
                        JSONObject obj = new JSONObject(responseBody.string());
                        if(obj.getString("ans").equals("badpassword")){
                            my_view.throwNote("bad password");
                        }else if(obj.getString("ans").equals("badusername")){
                            my_view.throwNote("bad username");
                        }
                        else {
                            User new_user = new User(obj);
                            my_view.signInSucces(new_user);
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

    public void succesLogin( User temp_user)
    {
        my_view.signInSucces(temp_user);
    }

    public void throwNote(String content)
    {
        my_view.throwNote(content);
    }


}
