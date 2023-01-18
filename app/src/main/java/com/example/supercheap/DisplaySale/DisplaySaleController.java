package com.example.supercheap.DisplaySale;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.supercheap.DisplayComment.CommentDisplay;
import com.example.supercheap.DisplayComment.DisplayCommentModel;
import com.example.supercheap.DisplayComment.DisplayCommentView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DisplaySaleController {
    private DisplaySaleModel model;
    private DisplaySaleView view;
    private OkHttpClient client;
    private ArrayList<SalesDisplay> sales;
    private int size;

    public DisplaySaleController(DisplaySaleView view) {
        this.model = new DisplaySaleModel(this, view);
        this.view = view;
        this.client = new OkHttpClient();
        this.size = 0;
        this.sales = new ArrayList<>();
    }

    public DisplaySaleModel getModel() {
        return model;
    }

    public void setModel(DisplaySaleModel model) {
        this.model = model;
    }

    public DisplaySaleView getView() {
        return view;
    }

    public void setView(DisplaySaleView view) {
        this.view = view;
    }

    public void init(String super_name, String super_city){
        boolean is_valid = this.model.checkInfo(super_name, super_city);
        if(is_valid){
            super_name = this.model.lowerCase(super_name);
            super_city = this.model.lowerCase(super_city);
            sendInfo(super_name, super_city);
        }else{
            this.view.promptMsg("data isnt valid");
        }
    }

    public void sendInfo(String super_name, String super_city){
        String url = "http://10.0.2.2:5000/displaysale?super_name=" + super_name
                + "&super_city=" + super_city;

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
                    try{
                        JSONObject obj = new JSONObject(responseBody.string());
                        if(!obj.getString("ans").equals("success")){
                            view.promptMsg("there are no sales");
                            view.failToDisplay();
                        }else{
                            JSONArray keys = obj.names ();
                            size = keys.length()-1;
                            for (int i = 0; i < keys.length(); i++) {
                                String key = keys.getString (i); // Here's your key
                                if(!key.equals("ans")){
                                    JSONObject value = obj.getJSONObject(key); // Here's your value
                                    String sale_name = value.getString("sale_name");
                                    String item = value.getString("item name");
                                    String company = value.getString("company");
                                    String quantity = value.getString("quantity");
                                    String price = value.getString("price");

                                    addSaleToList(sale_name, item, company, quantity, price);

                                }
                            }
                        }
                    }catch (Exception e){
                        view.promptMsg("something went wrong");
                    }
                }
                else
                {
                    view.promptMsg("error in getting response");
                }
            }
        });
    }

    public void addSaleToList(String sale_name, String item, String company, String quantity, String price){
        SalesDisplay new_sale = new SalesDisplay(sale_name, item, company, quantity, price);
        this.sales.add(new_sale);
        if(this.sales.size() == this.size){
            view.showSales(this.sales);
        }
    }
}
