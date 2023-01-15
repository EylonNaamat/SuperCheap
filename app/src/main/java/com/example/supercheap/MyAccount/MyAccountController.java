package com.example.supercheap.MyAccount;

import androidx.annotation.NonNull;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MyAccountController {
    MyAccountActivity my_view;
    MyAccountModel my_modle;
    private OkHttpClient client;

    public MyAccountController(MyAccountActivity temp_view)
    {
        this.my_view = temp_view;
        this.my_modle = new MyAccountModel(this, temp_view);
        this.client = new OkHttpClient();

    }

    public void throwNote(String content)
    {
        my_view.throwNote(content);
    }

    public void updateUser(String first_name,String last_name,String email, String password,String city,String birth_date,boolean male,boolean female) {
        my_modle.checkuserdetails(first_name, last_name, email, password, city, birth_date, male, female);
    }
    public void updateUserindata(String first_name,String last_name,String email, String password,String city,String birth_date,String gender)
    {
        String url = "http://10.0.2.2:5000/myaccount/setuser?first_name=" + first_name
                + "&last_name=" + last_name + "&email=" + email
                + "&username=" + my_view.user.getUsername() + "&password=" + password
                + "&city=" + city + "&birth_date=" + birth_date
                + "&gender=" + gender + "&is_manager=" + my_view.user.getIs_manager()
                + "&super_id=" + my_view.user.getSuper_id();

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
                            my_view.throwNote("user change successful");
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
        my_view.user.setFirst_name(first_name);
        my_view.user.setLast_name(last_name);
        my_view.user.setEmail(email);
        my_view.user.setPassword(password);
        my_view.user.setCity(city);
        my_view.user.setBirth_date(birth_date);
        my_view.user.setGender(gender);
    }
}
