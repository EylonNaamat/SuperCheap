package com.example.supercheap.SignIn;

import android.util.Log;

import com.example.supercheap.Classes.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ModelSignin {

    private ControllerSignin my_contorol;
    private SigninActivity my_view;
    private DatabaseReference my_bd;
    String old_pass;

    public ModelSignin(ControllerSignin contoroler, SigninActivity view) {
        this.my_contorol = contoroler;
        this.my_view = view;
        this.my_bd = FirebaseDatabase.getInstance().getReference();
    }
    //check the details format is ok
    public void DoLogIN(String username, String password) {

        if (username.isEmpty() || password.isEmpty()) {
            my_contorol.throwNote("bad password or usrname");
        }
        else
        {
            my_contorol.doLogin(username, password);
        }
    }
}
