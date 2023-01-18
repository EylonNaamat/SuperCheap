package com.example.supercheap.DeleteProduct;

import com.example.supercheap.Classes.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteModel {
    private DeleteController MController;
    private DatabaseReference my_db;
    private User my_user;
    private DatabaseReference databasereference;
    private DeleteProductsActivity deleteProductsActivity;


    public DeleteModel(DeleteController controllerManager, DeleteProductsActivity deleteProductsActivity) {
        this.MController = controllerManager;
        this.my_db = FirebaseDatabase.getInstance().getReference();
        this.databasereference = FirebaseDatabase.getInstance().getReference();
        this.deleteProductsActivity = deleteProductsActivity;

    }

    public void ValData(String itemName, String company, User user) {
        if (itemName.length() == 0 || company.length() == 0) {
            deleteProductsActivity.throwNote("bad input");
        } else {
            MController.TryDelete(itemName.toLowerCase(), company.toLowerCase(), user);
        }
    }
}
