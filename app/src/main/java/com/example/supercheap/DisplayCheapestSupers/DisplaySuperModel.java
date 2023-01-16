package com.example.supercheap.DisplayCheapestSupers;

import android.util.Log;

import com.example.supercheap.Classes.Super;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DisplaySuperModel {
    private DisplaySuperController controller;
    private ArrayList<String> super_ids;
    private DatabaseReference databasereference;
    private MainPageDisplay view;

    public DisplaySuperModel(DisplaySuperController controller, MainPageDisplay view){
        this.controller = controller;
        this.super_ids = new ArrayList<>();
        this.databasereference = FirebaseDatabase.getInstance().getReference();
        this.view = view;
    }

    public HashMap<String,String> lowerItems(HashMap<String,String> item_list){
        HashMap<String,String> new_list = new HashMap<>();
        for(Map.Entry<String,String> set : item_list.entrySet()){
            String key = set.getKey().toLowerCase();
            String val = set.getValue().toLowerCase();
            new_list.put(key, val);
        }
        return new_list;
    }

    public String lowerCity(String city){
        return city.toLowerCase();
    }

    public String stringItems(HashMap<String,String> item_list){
        item_list = lowerItems(item_list);

        String ans = "";
        for(Map.Entry<String,String> set : item_list.entrySet()){
            String key = set.getKey().toLowerCase();
            String val = set.getValue().toLowerCase();
            ans += key + "-" + val + ",";
        }
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }

    public boolean checkCity(String city){
        if(city.isEmpty()){
            this.view.promptMsg("you didnt enter city");
            return false;
        }
        return true;
    }

    public boolean checkItemList(HashMap<String,String> item_list){
        if(item_list.isEmpty()){
            this.view.promptMsg("you didnt enter item list");
            return false;
        }
        return true;
    }
}
