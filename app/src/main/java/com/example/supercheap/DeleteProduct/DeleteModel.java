package com.example.supercheap.DeleteProduct;

import com.example.supercheap.Classes.User;
import com.example.supercheap.Manager.ControllerManager;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteModel {
    private DeleteController MController;
    private DatabaseReference my_db;
    private User my_user;
    private DatabaseReference databasereference;


    public DeleteModel(DeleteController controllerManager) {
        this.MController=controllerManager;
        this.my_db= FirebaseDatabase.getInstance().getReference();
        this.databasereference = FirebaseDatabase.getInstance().getReference();

    }



    public void DoDelete(String itemName, String company, User user) {
        MController.Done(itemName + "=" + company);
        databasereference.child("Supers").child(user.getSuper_id()).child("products").child(itemName).child(company).removeValue();
    }
}
