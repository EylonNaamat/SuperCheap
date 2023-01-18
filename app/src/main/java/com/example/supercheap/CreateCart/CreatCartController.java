package com.example.supercheap.CreateCart;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.supercheap.Classes.User;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CreatCartController {
    private CreateCart createCart;
    private CreateCartModel creatCartModel;
    private OkHttpClient client;


    public CreatCartController(CreateCart createCart) {
        this.creatCartModel = new CreateCartModel(this, createCart);
        this.createCart = createCart;
        this.client = new OkHttpClient();

    }

    public void validCity(ArrayList<String> arrayList, String city, User user) {
        creatCartModel.validCity(arrayList, city, user);
    }

    /*this function convert the arraylist to hashmap*/
    public HashMap<String, String> convertArrayListToHash(ArrayList<String> arrayList) {
        HashMap<String, String> myHash = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String k = arrayList.get(i);
            String[] h = k.split(",");
            myHash.put(h[0], h[1]);
        }
        return myHash;
    }

    public void IsCity(String city) {
        String url = "http://10.0.2.2:5000/IsCity?city_name=" + city;
        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                createCart.throwNote("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    try {
                        JSONObject obj = new JSONObject(responseBody.string());
                        if (obj.getString("is_city").equals("doesnt exists")) {
                            createCart.throwNote("City doesn't exists");
                        } else if (obj.getString("is_city").equals("exists")) {
                            confindcheaper(city);
                        }
                    } catch (Exception e) {
                        createCart.throwNote("error in getting ans!");
                    }
                } else {
                    createCart.throwNote("error in getting response");
                }
            }
        });
    }

    private void confindcheaper(String city) {
        createCart.find(city);
    }

    public void isItem(String item, String company, String quantity) {
        String url = "http://10.0.2.2:5000/IsItem?item_name=" + item;
        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                createCart.throwNote("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    try {
                        JSONObject obj = new JSONObject(responseBody.string());
                        if (obj.getString("is_item").equals("doesnt exists")) {
                            createCart.throwNote("error in getting ans!!");
                        } else if (obj.getString("is_item").equals("exists")) {
                            createCart.throwNote("Item exists");
                            createCart.add(item, company, quantity);
                        }
                    } catch (Exception e) {

                        createCart.throwNote("error in getting ans!");
                    }
                } else {
                    createCart.throwNote("error in getting response");
                }
            }
        });
    }


    public void ValidInput(String item_name, String company_name, String quantity) {
        creatCartModel.checkAndLower(item_name, company_name, quantity);
    }
}
