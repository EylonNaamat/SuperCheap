package com.example.supercheap.Manager;

import com.example.supercheap.Classes.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ManagerModel {
    private ControllerManager MController;
    private DatabaseReference my_db;
    private User my_user;
    private DatabaseReference databasereference;


    public ManagerModel(ControllerManager controllerManager) {
        this.MController=controllerManager;
        this.my_db= FirebaseDatabase.getInstance().getReference();
        this.databasereference = FirebaseDatabase.getInstance().getReference();

        //this.my_user=
    }

    public void DoInsert(String itemName, double price, String company, User user) {
        MController.Done(itemName + "=" + String.valueOf(price));
        databasereference.child("Supers").child(user.getSuper_id()).child("products").child(itemName).child(company).setValue(price);
    }


    public void DoSale(String saleName, int saleQuantity, double priceSale, String company, User user) {
        MController.Done("Name="+saleName+" ,quantity="+String.valueOf(saleQuantity)+",price="+String.valueOf(priceSale));
        databasereference.child("Supers").child("aa").child("a").setValue(4.0);
    }
}
