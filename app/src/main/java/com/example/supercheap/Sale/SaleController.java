package com.example.supercheap.Sale;

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

public class SaleController {
    private SaleView saleView;
    private SaleModel saleModel;
    private OkHttpClient client;

    public SaleController(SaleView saleView) {
        this.client = new OkHttpClient();
        this.saleView = saleView;
        this.saleModel = new SaleModel(this, saleView);

    }

    public void ValidInput(String item_name, String company, String quantity, String price, String sale_name, User user) {
        this.saleModel.ValData(item_name, company, quantity, price, sale_name, user);
    }
    /* this function send http request to BL docker */
    public void TrySale(String item_name, String company, String saleQuantity, String priceSale, String sale_name, User user) {
        String url = "http://10.0.2.2:5000/DoSale?item_name=" + item_name
                + "&saleQuantity=" + saleQuantity + "&priceSale=" + priceSale
                + "&company=" + company + "&sale_name=" + sale_name + "&super_id=" + user.getSuper_id();
        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                saleView.throwNote("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    try {
                        JSONObject obj = new JSONObject(responseBody.string());
                        if (obj.getString("do_sale").equals("error")) {
                            saleView.throwNote("error in getting ans!!");
                        } else if (obj.getString("do_sale").equals("good")) {
                            saleView.throwNote("Sale inserted");
                        } else if (obj.getString("do_sale").equals("sale exists")) {
                            saleView.throwNote("Sale name already exists");
                        } else if (obj.getString("do_sale").equals("doesnt exists")) {
                            saleView.throwNote("item name or company doesnt exists");
                        } else if (obj.getString("do_sale").equals("error_search")) {
                            saleView.throwNote("error in search item");
                        }
                    } catch (Exception e) {

                        saleView.throwNote("error in getting ans!");
                    }
                } else {
                    saleView.throwNote("error in getting response");
                }
            }
        });
    }
}
