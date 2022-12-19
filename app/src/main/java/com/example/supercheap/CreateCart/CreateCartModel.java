package com.example.supercheap.CreateCart;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateCartModel {
    private DatabaseReference my_bd;
    CreatCartController creatCartController;
    public CreateCartModel(CreatCartController creatCartController) {
        this.my_bd = FirebaseDatabase.getInstance().getReference();
        this.creatCartController=creatCartController;
    }

    //find if item name in the firebase
    public void DoInDict(String item) {
        my_bd.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 if(snapshot.child("dict_product").hasChild(item)){
                     creatCartController.addTolist(item);
                 }else{
                     creatCartController.toast("This item doesn't exist in any super");
                 }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    //find if city in the firebase

    public void DoInCity(String item) {

        my_bd.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child("cities").hasChild(item)){
                    creatCartController.confindcheaper(item);
                }else{
                    creatCartController.toast("This super name doesn't exist in any super");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
