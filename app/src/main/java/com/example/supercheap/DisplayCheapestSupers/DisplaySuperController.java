package com.example.supercheap.DisplayCheapestSupers;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DisplaySuperController {
    static int counter_checked = 0;
    ArrayList<SuperDisplay> supers;
    private DisplaySuperModel model;
    private MainPageDisplay view;
    HashMap<String,String> item_list;
    private OkHttpClient client;
    private int size;
    private String city;
    // if array size is n call view to display


    public DisplaySuperController(MainPageDisplay view, HashMap<String,String> item_list) {
        this.supers = new ArrayList<>();
        this.model = new DisplaySuperModel(this, view);
        this.view = view;
        this.item_list = item_list;
        this.size = 0;
        this.client = new OkHttpClient();
    }

    public static int getCounter_checked() {
        return counter_checked;
    }

    public static void setCounter_checked(int counter_checked) {
        DisplaySuperController.counter_checked = counter_checked;
    }

    public ArrayList<SuperDisplay> getSupers() {
        return supers;
    }

    public void setSupers(ArrayList<SuperDisplay> supers) {
        this.supers = supers;
    }

    public DisplaySuperModel getModel() {
        return model;
    }

    public void setModel(DisplaySuperModel model) {
        this.model = model;
    }

    public MainPageDisplay getView() {
        return view;
    }

    public void setView(MainPageDisplay view) {
        this.view = view;
    }

    public HashMap<String, String> getItem_list() {
        return item_list;
    }

    public void setItem_list(HashMap<String, String> item_list) {
        this.item_list = item_list;
    }


    public void fillSupers(String city, HashMap<String,String> item_list){
        if(this.model.checkCity(city) && this.model.checkItemList(item_list)){
            city = this.model.lowerCity(city);
            this.city = city;
            String items = this.model.stringItems(item_list);
            sendRequest(city, items);
        }
    }

    public void sendRequest(String city, String item_list){
        String url = "http://10.0.2.2:5000/displaysuper?city=" + city
                + "&itemlist=" + item_list;

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
                        if(!obj.getString("ans").equals("success")){
                            view.promptMsg("something went wrong with the calculation");
                            view.failToDisplay();
                        }else{
                            JSONArray keys = obj.names ();
                            size = keys.length()-1;
                            for (int i = 0; i < keys.length(); i++) {
                                String key = keys.getString (i); // Here's your key
                                if(!key.equals("ans")){
                                    String value = obj.getString (key); // Here's your value
                                    HashMap<String,String> super_data = stringToHashMap(value);
                                    addPriceToList(super_data.get("super_name"), super_data.get("missing_items"),
                                            super_data.get("substitute_item"), super_data.get("total_price"),
                                            super_data.get("rating"), super_data.get("num_comments"), city);
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

    public void addPriceToList(String super_name, String missing_items, String substitute_item, String total_price, String rating, String num_comments, String city){
        // creating the super display according to the model info
        // and adding this done super to the arraylist to be presented in view
        SuperDisplay new_super = new SuperDisplay(super_name, missing_items, substitute_item, total_price, rating, num_comments, city);
        this.supers.add(new_super);
        if(this.supers.size() == this.size){
            // after filling the array list to be displayed in view, we first sort it and then sending it to the view
            sortSupers();
            view.showSupers(this.supers);
        }
    }

    // sorting function
    // priority 1 is the number of missing items
    // priority 2 is the number of substitute items
    // priority 3 is the cart total price
    public void sortSupers(){
        Collections.sort(this.supers, new Comparator<SuperDisplay>() {
            @Override
            public int compare(SuperDisplay o1, SuperDisplay o2) {
                if(Integer.parseInt(o1.getMissing_items()) > Integer.parseInt(o2.getMissing_items())){
                    return 1;
                }else if(Integer.parseInt(o1.getMissing_items()) == Integer.parseInt(o2.getMissing_items())){
                    if(Integer.parseInt(o1.getSubstitute_item()) > Integer.parseInt(o2.getSubstitute_item())){
                        return 1;
                    }else if(Integer.parseInt(o1.getSubstitute_item()) == Integer.parseInt(o2.getSubstitute_item())){
                        if(Integer.parseInt(o1.getTotal_price()) > Integer.parseInt(o2.getTotal_price())){
                            return 1;
                        }else if(Integer.parseInt(o1.getTotal_price()) == Integer.parseInt(o2.getTotal_price())){
                            return 0;
                        }
                    }
                }
                return -1;
            }
        });
    }

    public HashMap<String, String> stringToHashMap(String super_data){
        HashMap<String,String> ans = new HashMap<>();
        String[] split_by_comma = super_data.split(",");
        for(int i = 0; i < split_by_comma.length; i++){
            String[] key_val = split_by_comma[i].split("-");
            ans.put(key_val[0], key_val[1]);
        }
        return ans;
    }

}
