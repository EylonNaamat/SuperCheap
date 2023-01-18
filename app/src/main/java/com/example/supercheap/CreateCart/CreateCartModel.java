package com.example.supercheap.CreateCart;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.supercheap.Classes.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CreateCartModel {
    private DatabaseReference my_bd;
    private CreatCartController creatCartController;
    private CreateCart createCart;

    public CreateCartModel(CreatCartController creatCartController, CreateCart createCart) {
        this.my_bd = FirebaseDatabase.getInstance().getReference();
        this.creatCartController = creatCartController;
        this.createCart = createCart;


    }
    /* This function check if the item input is valid */
    public void checkAndLower(String item_name, String company_name, String quantity) {
        if (item_name.length() == 0 || company_name.length() == 0 || quantity.length() == 0) {
            createCart.throwNote("Bad input");
            createCart.resetText();
        } else {
            creatCartController.isItem(item_name.toLowerCase(), company_name.toLowerCase(), quantity.toLowerCase());
        }
    }

    /* This function check if the city input is valid */

    public void validCity(ArrayList<String> arrayList, String city, User user) {
        if (arrayList.size() == 0) {
            createCart.throwNote("The list empty");

        } else if (city.length() == 0) {
            createCart.throwNote("No entered City");
        } else {
            creatCartController.IsCity(city.toLowerCase());
        }
    }
}

