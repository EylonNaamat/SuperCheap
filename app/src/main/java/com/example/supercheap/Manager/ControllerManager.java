package com.example.supercheap.Manager;

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

public class ControllerManager {
    private ManagerPage my_manager_view;
    private ManagerModel my_man_mod;
    private OkHttpClient client;

    public ControllerManager(ManagerPage managerPage) {
        this.my_man_mod=new ManagerModel(this,managerPage);
        this.my_manager_view=managerPage;
        this.client = new OkHttpClient();

    }



    public void TryInsert(String itemName, String price, String company, User user) {
            String url = "http://10.0.2.2:5000/addItem?itemname=" + itemName
                    + "&price=" + price + "&company=" + company
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
                    if(response.isSuccessful())
                    {
                        ResponseBody responseBody = response.body();
                        try{
                            JSONObject obj = new JSONObject(responseBody.string());
                            if(obj.getString("add_item").equals("error")){
                                my_manager_view.throwNote("error in getting ans");
                            }else if(obj.getString("add_item").equals("good")){
                                my_manager_view.throwNote("Item inserted");
                            }
                        }catch (Exception e){

                            my_manager_view.throwNote("error in getting ans!");
                        }
                    }
                    else
                    {
                        my_manager_view.throwNote("error in getting response");
                    }
                }
            });
    }
    public void TryUpdate(String saleName, String saleQuantity, String priceSale, String company, User user) {
        if (saleName.length() == 0 || priceSale.length() == 0 ||saleQuantity.length()==0|| company.length() == 0) {
            my_manager_view.throwNote("bad input");
        } else {
            my_man_mod.DoSale(saleName, Integer.parseInt(saleQuantity), Double.parseDouble(priceSale), company, user);
        }
    }
    public void Done(String s){my_manager_view.throwNote(s);}

    public void ValidInput(String itemName, String price, String company, User user) {
        my_man_mod.ValData(itemName,price,company,user);
    }
}
