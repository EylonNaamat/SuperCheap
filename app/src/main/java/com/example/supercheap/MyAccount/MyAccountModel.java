package com.example.supercheap.MyAccount;

import com.example.supercheap.Classes.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyAccountModel {
    MyAccountController my_control;
    private DatabaseReference my_bd;

    public MyAccountModel(MyAccountController temp_con)
    {
        this.my_control = temp_con;
        this.my_bd = FirebaseDatabase.getInstance().getReference();
    }

    public void setupdateuser(User new_user)
    {
        this.my_bd.child("users").child(new_user.getUsername()).setValue(new_user);
    }

}
