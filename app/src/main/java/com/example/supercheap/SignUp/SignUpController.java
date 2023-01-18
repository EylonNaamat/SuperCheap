package com.example.supercheap.SignUp;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.supercheap.Classes.Super;
import com.example.supercheap.Classes.User;

import org.json.JSONObject;

import java.io.IOException;
import java.util.UUID;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class SignUpController {
    private SignUpActivity view;
    private SignUpModel model;
    private OkHttpClient client;

    public SignUpController(SignUpActivity view) {
        this.view = view;
        this.model = new SignUpModel(view, this);
        this.client = new OkHttpClient();
    }

    public void processingNewUser(String first_name, String last_name, String email, String username, String password, String city, String birth_date, boolean male, boolean female, boolean yes_manager, boolean no_manager, String super_name, String super_city){
        model.checkUserInfo(first_name, last_name, email, username, password, city, birth_date, male, female, yes_manager, no_manager, super_name, super_city);
    }

    public void sendUser(User user, Super my_super){
        String url = "http://10.0.2.2:5000/signup/user?first_name=" + user.getFirst_name()
                + "&last_name=" + user.getLast_name() + "&email=" + user.getEmail()
                + "&username=" + user.getUsername() + "&password=" + user.getPassword()
                + "&city=" + user.getCity() + "&birth_date=" + user.getBirth_date()
                + "&gender=" + user.getGender() + "&is_manager=" + user.getIs_manager()
                + "&super_id=" + user.getSuper_id();
//            http://localhost:5000/signup/user?first_name=eylon&last_name=naamat&username=user.getUsername()&password=user.getPassword()&city=user.getCity()&birth_date=user.getBirth_date()&gender=user.getGender()&is_manager=true&super_id=getSuper_id()
//        "http://localhost:5000/signup/user?first_name=eylon&last_name=naamat&username=user.getUsername()&password=user.getPassword()&city=user.getCity()&birth_date=user.getBirth_date()&gender=user.getGender()&is_manager=true&super_id=getSuper_id()"

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
                    String res = "";
                    try{
                        JSONObject obj = new JSONObject(responseBody.string());
                        if(obj.getString("user").equals("exists")){
                            res = "user already exists";
                        }else if(obj.getString("user").equals("error")){
                            res = "an error has occurred insertion failed";
                        }else{
                            if(user.getIs_manager()){
                                sendSuper(my_super);
                                sendCity(my_super);
                            }
                            res = "insertion went well";
                            view.greet(user);
                        }
                    }catch (Exception e){
                        res = "error in getting ans";
                    }
                    view.promptMsg(res);
                }
                else
                {
                    view.promptMsg("error in getting response");
                }
            }
        });
    }

    public void sendSuper(Super my_super){
        Log.d("test_signup", "10");
        String url = "http://10.0.2.2:5000/signup/super?super_ID=" + my_super.getSuper_ID()
                    + "&super_name=" + my_super.getSuper_name() + "&super_city=" + my_super.getSuper_city()
                    + "&comments_size=" +my_super.getComments_size() + "&super_rating=" + my_super.getSuper_rating();

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
                    String res = "";
                    try{
                        JSONObject obj = new JSONObject(responseBody.string());
                        if(obj.getString("super").equals("error")){
                            res = "an error has occurred insertion failed";
                        }
                    }catch (Exception e){
                        res = "error in getting ans";
                    }
                    view.promptMsg(res);
                }
                else
                {
                    view.promptMsg("error in getting response");
                }
            }
        });
    }

    public void sendCity(Super my_super){
        Log.d("test_signup", "19");
        String url = "http://10.0.2.2:5000/signup/city?super_ID=" + my_super.getSuper_ID()
                + "&super_name=" + my_super.getSuper_name() + "&super_city=" + my_super.getSuper_city()
                + "&comments_size=" +my_super.getComments_size() + "&super_rating=" + my_super.getSuper_rating();

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
                    String res = "";
                    try{
                        JSONObject obj = new JSONObject(responseBody.string());
                        if(obj.getString("city").equals("error")){
                            res = "an error has occurred insertion failed";
                        }
                    }catch (Exception e){
                        res = "error in getting ans";
                    }
                    view.promptMsg(res);
                }
                else
                {
                    view.promptMsg("error in getting response");
                }
            }
        });
    }

    public void failCreation(String error){
        view.promptError(error);
    }

}
