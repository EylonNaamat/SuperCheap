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
        Log.d("test_signup", "1");
        String url = "http://10.0.2.2:5000/signup/user?first_name=" + user.getFirst_name()
                + "&last_name=" + user.getLast_name() + "&email=" + user.getEmail()
                + "&username=" + user.getUsername() + "&password=" + user.getPassword()
                + "&city=" + user.getCity() + "&birth_date=" + user.getBirth_date()
                + "&gender=" + user.getGender() + "&is_manager=" + user.getIs_manager()
                + "&super_id=" + user.getSuper_id();
//            http://localhost:5000/signup/user?first_name=eylon&last_name=naamat&username=user.getUsername()&password=user.getPassword()&city=user.getCity()&birth_date=user.getBirth_date()&gender=user.getGender()&is_manager=true&super_id=getSuper_id()
//        "http://localhost:5000/signup/user?first_name=eylon&last_name=naamat&username=user.getUsername()&password=user.getPassword()&city=user.getCity()&birth_date=user.getBirth_date()&gender=user.getGender()&is_manager=true&super_id=getSuper_id()"
        Log.d("test_signup", "2");

        Request request = new Request.Builder().url(url).build();
        Log.d("test_signup", "3");
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("test_signup", "dont work1");
                failCreation("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d("test_signup", "4");
                if(response.isSuccessful())
                {
                    Log.d("test_signup", "5");
                    ResponseBody responseBody = response.body();
                    try{
                        Log.d("test_signup", "6");
                        JSONObject obj = new JSONObject(responseBody.string());
                        Log.d("test_signup", "7");
                        Log.d("test_signup", obj.toString());
                        if(obj.getString("user").equals("exists")){
                            view.promptError("user already exists");
                        }else if(obj.getString("user").equals("error")){
                            view.promptError("an error has occurred insertion failed");
                        }else{
                            if(user.getIs_manager()){
                                sendSuper(my_super);
                                sendCity(my_super);
                            }
                            view.greet(user);
                        }
                        Log.d("test_signup", "8");
                    }catch (Exception e){
                        Log.d("test_signup", "dont work3");
                        failCreation("error in getting ans");
                    }
                    Log.d("test_signup", "work");
                }
                else
                {
                    Log.d("test_signup", "dont work2");
                    failCreation("error in getting response");
                }
            }
        });
        Log.d("test_signup", "9");
    }

    public void sendSuper(Super my_super){
        Log.d("test_signup", "10");
        String url = "http://10.0.2.2:5000/signup/super?super_ID=" + my_super.getSuper_ID()
                    + "&super_name=" + my_super.getSuper_name() + "&super_city=" + my_super.getSuper_city()
                    + "&comments_size=" +my_super.getComments_size() + "&super_rating=" + my_super.getSuper_rating();
        Log.d("test_signup", "11");
        Request request = new Request.Builder().url(url).build();
        Log.d("test_signup", "12");
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("test_signup", "dont work1");
                failCreation("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d("test_signup", "13");
                if(response.isSuccessful())
                {
                    Log.d("test_signup", "14");
                    ResponseBody responseBody = response.body();
                    try{
                        Log.d("test_signup", "15");
                        JSONObject obj = new JSONObject(responseBody.string());
                        Log.d("test_signup", "16");
                        Log.d("test_signup", obj.toString());
                        if(obj.getString("super").equals("error")){
                            view.promptError("an error has occurred insertion failed");
                        }
                        Log.d("test_signup", "17");
                    }catch (Exception e){
                        Log.d("test_signup", "dont work3");
                        failCreation("error in getting ans");
                    }
                    Log.d("test_signup", "work");
                }
                else
                {
                    Log.d("test_signup", "dont work2");
                    failCreation("error in getting response");
                }
            }
        });
        Log.d("test_signup", "18");
    }


    public void sendCity(Super my_super){
        Log.d("test_signup", "19");
        String url = "http://10.0.2.2:5000/signup/city?super_ID=" + my_super.getSuper_ID()
                + "&super_name=" + my_super.getSuper_name() + "&super_city=" + my_super.getSuper_city()
                + "&comments_size=" +my_super.getComments_size() + "&super_rating=" + my_super.getSuper_rating();
        Log.d("test_signup", "20");
        Request request = new Request.Builder().url(url).build();
        Log.d("test_signup", "21");
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("test_signup", "dont work1");
                failCreation("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d("test_signup", "22");
                if(response.isSuccessful())
                {
                    Log.d("test_signup", "23");
                    ResponseBody responseBody = response.body();
                    try{
                        Log.d("test_signup", "24");
                        JSONObject obj = new JSONObject(responseBody.string());
                        Log.d("test_signup", "25");
                        Log.d("test_signup", obj.toString());
                        if(obj.getString("city").equals("error")){
                            view.promptError("an error has occurred insertion failed");
                        }
                        Log.d("test_signup", "26");
                    }catch (Exception e){
                        Log.d("test_signup", "dont work3");
                        failCreation("error in getting ans");
                    }
                    Log.d("test_signup", "work");
                }
                else
                {
                    Log.d("test_signup", "dont work2");
                    failCreation("error in getting response");
                }
            }
        });
        Log.d("test_signup", "27");
    }

    public void failCreation(String error){
        view.promptError(error);
        Log.d("testtest", "controller fail ");
    }

}
