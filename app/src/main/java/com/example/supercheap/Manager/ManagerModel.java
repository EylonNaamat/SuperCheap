package com.example.supercheap.Manager;

import com.example.supercheap.Classes.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ManagerModel {
    private ControllerManager MController;
    private DatabaseReference my_db;
    private DatabaseReference databasereference;
    private ManagerPage managerPage;


    public ManagerModel(ControllerManager controllerManager,ManagerPage managerPage) {
        this.MController=controllerManager;
        this.my_db= FirebaseDatabase.getInstance().getReference();
        this.databasereference = FirebaseDatabase.getInstance().getReference();
        this.managerPage=managerPage;

    }


    public void DoSale(String saleName, int saleQuantity, double priceSale, String company, User user) {
        MController.Done("Name="+saleName+" ,quantity="+String.valueOf(saleQuantity)+",price="+String.valueOf(priceSale));
        databasereference.child("Supers").child("aa").child("a").setValue(4.0);
    }

    public void ValData(String itemName, String price, String company, User user) {
        if (itemName.length() == 0 || price.length() == 0 || company.length() == 0) {
            managerPage.throwNote("bad input");
        }else{
            MController.TryInsert(itemName,price,company,user);
        }
    }
}
