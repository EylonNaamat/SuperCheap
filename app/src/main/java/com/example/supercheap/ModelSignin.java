package com.example.supercheap;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ModelSignin {

    private ControllerSignin my_contorol;
    private DatabaseReference my_bd;
    private User my_user;

    public ModelSignin(ControllerSignin contoroler) {
        this.my_contorol = contoroler;
        this.my_bd = FirebaseDatabase.getInstance().getReference();
        this.my_user = new User();

    }

    public ControllerSignin getMy_contorol() {
        return my_contorol;
    }

    public void setMy_contorol(ControllerSignin my_contorol) {
        this.my_contorol = my_contorol;
    }

    public DatabaseReference getMy_bd() {
        return my_bd;
    }

    public void setMy_bd(DatabaseReference my_bd) {
        this.my_bd = my_bd;
    }

    public User getMy_user() {
        return my_user;
    }

    public void setMy_user(User my_user) {
        this.my_user = new User(my_user);
    }

    public void DoLogIN(String username, String password) {

        if(username.isEmpty() || password.isEmpty())
        {
            my_contorol.failLogin();
        }
        else
        {
            ValueEventListener postListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    if (!dataSnapshot.hasChild(username)) {
                        my_contorol.failLogin();
                    } else {
                        User temp_user = dataSnapshot.child(username).getValue(User.class);
                        if (!temp_user.getPassword().equals(password)) {
                            my_contorol.failLogin();
                        } else {
                            my_user = new User(temp_user);
                            my_contorol.succesLogin();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w("ds", "loadPost:onCancelled", databaseError.toException());
                }
            };
            this.my_bd.child("users").addValueEventListener(postListener);
        }
    }
}
