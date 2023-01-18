package com.example.supercheap.DeleteSale;

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

public class DeleteSaleController {
    private DeleteSale deleteSale;
    private DeleteSaleModel deleteSaleModel;
    private OkHttpClient client;

    public DeleteSaleController(DeleteSale deleteSale) {
        this.deleteSaleModel = new DeleteSaleModel(this, deleteSale);
        this.deleteSale = deleteSale;
        this.client = new OkHttpClient();
    }

    public void ValidInput(String salename, User user) {
        deleteSaleModel.ValData(salename, user);
    }

    public void TryDeleteSale(String sale_name, User user) {
        //http request to BL
        String url = "http://10.0.2.2:5000/deleteSale?sale_name=" + sale_name
                + "&super_id=" + user.getSuper_id();
        Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                deleteSale.throwNote("error in failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    try {
                        JSONObject obj = new JSONObject(responseBody.string());
                        if (obj.getString("delete_sale").equals("error")) {
                            deleteSale.throwNote("error in getting ans");
                        } else if (obj.getString("delete_sale").equals("sale doesn't exists")) {
                            deleteSale.throwNote("Sale doesn't exists");
                        } else if (obj.getString("delete_sale").equals("good")) {
                            deleteSale.throwNote("Sale deleted");
                        }
                    } catch (Exception e) {
                        deleteSale.throwNote("error in getting ans!");
                    }
                } else {
                    deleteSale.throwNote("error in getting response");
                }
            }
        });
    }
}
