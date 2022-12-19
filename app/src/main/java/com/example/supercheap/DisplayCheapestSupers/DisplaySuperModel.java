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
import java.util.Map;

public class DisplaySuperModel {
    private DisplaySuperController controller;
    private ArrayList<String> super_ids;
    private DatabaseReference databasereference;

    public DisplaySuperModel(DisplaySuperController controller){
        this.controller = controller;
        this.super_ids = new ArrayList<>();
        this.databasereference = FirebaseDatabase.getInstance().getReference();
    }


    // for on superids
    // adds to controller list

    public void getSupers(String city){
        DatabaseReference curr_datareference = this.databasereference.child("cities");
        curr_datareference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.hasChild(city)) {
                    // getting all super ids in the city that were asked
                    snapshot = snapshot.child(city);
                    for(DataSnapshot snap_id : snapshot.getChildren()){
                        super_ids.add(String.valueOf(snap_id.getKey()));
                    }
                    // after finishing to fill al super ids tell the controller its full
                    notifyController();
                } else {
                    controller.failSearch("no supers in city");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                controller.failSearch("something went wrong");
            }

        });
    }

    public void notifyController(){
        // sending the full super id list to controller
        controller.createHash(this.super_ids);
    }

    public void calculateCart(String super_id, HashMap<String,String> item_list){
        Log.d("displaycheck", "super id is : " + super_id);

        DatabaseReference curr_datareference = this.databasereference.child("Supers").child(super_id);
        curr_datareference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // first getting the super name
                String super_name = String.valueOf(snapshot.child("super_name").getValue());
                Log.d("displaycheck", "super name : " + super_name);
                // checking the super's products
                snapshot = snapshot.child("products");
                int total_price = 0;
                int missing_item = 0;
                int subs = 0;
                // for each item on the list
                for(Map.Entry<String,String> set : item_list.entrySet()){
                    Log.d("displaycheck", "item : " + set.getKey());
                    // checking if the item exists, if not increment missing_items by 1
                    if (snapshot.hasChild(set.getKey())) {
                        Log.d("displaycheck", "super has : " + set.getKey());
                        DataSnapshot temp = snapshot.child(set.getKey());
                        // if the item exists checking if the brand the customer wanted exists,
                        // if not getting him the first brand there is, and inc. the subs counter
                        Log.d("displaycheck", "brand : " + set.getValue());
                        if(!(set.getValue().equals("")) && temp.hasChild(set.getValue())){
                            // if the exact item with its brand exists adding its price to the total_price
                            Log.d("displaycheck", "super has : " + set.getValue());
                            Log.d("displaycheck", "the price is : " + Integer.parseInt(String.valueOf((temp.child(set.getValue())).getValue())));
                            total_price += Integer.parseInt(String.valueOf((temp.child(set.getValue())).getValue()));
                            Log.d("displaycheck", "total price : " + total_price);
                        }else{
                            subs += 1;
                            // gets the next brand there is
                            int min = Integer.MAX_VALUE;
                            int curr_price = 0;
                            for(DataSnapshot brand_name : temp.getChildren()){
                                curr_price = Integer.parseInt(String.valueOf(brand_name.getValue()));
                                if(curr_price < min){
                                    min = curr_price;
                                }
                            }
                            total_price += curr_price;
                        }
                    } else {
                        missing_item += 1;
                    }
                }
                // giving the controller the super name, how many item are missing
                // how much substitute were made and the cart's total price
                controller.addPriceToList(super_name, missing_item, subs, total_price);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                controller.failSearch("something went wrong");
            }

        });

    }
}
