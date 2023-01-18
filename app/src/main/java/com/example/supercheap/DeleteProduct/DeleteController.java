package com.example.supercheap.DeleteProduct;


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

public class DeleteController {
    private DeleteProductsActivity my_manager_view;
    private DeleteModel my_del_mod;
    private OkHttpClient client;

    public DeleteController(DeleteProductsActivity managerPage) {
        this.my_del_mod = new DeleteModel(this, managerPage);
        this.my_manager_view = managerPage;
        this.client = new OkHttpClient();
    }


    public void TryDelete(String itemName, String company, User user) {

        String url = "http://10.0.2.2:5000/deleteItem?itemname=" + itemName
                + "&company=" + company
                + "&super_id=" + user.getSuper_id();
        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                my_manager_view.throwNote("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    try {
                        JSONObject obj = new JSONObject(responseBody.string());
                        if (obj.getString("delete_item").equals("error")) {
                            my_manager_view.throwNote("error in getting ans");
                        } else if (obj.getString("delete_item").equals("good")) {
                            my_manager_view.throwNote("Item deleted");
                        }
                    } catch (Exception e) {

                        my_manager_view.throwNote("error in getting ans!");
                    }
                } else {
                    my_manager_view.throwNote("error in getting response");
                }
            }
        });
    }

    public void ValidInput(String name, String company, User user) {
        my_del_mod.ValData(name, company, user);
    }
}