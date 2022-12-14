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
    private DatabaseReference my_bd;
    String old_pass;

    public ModelSignin(ControllerSignin contoroler) {
        this.my_contorol = contoroler;
        this.my_bd = FirebaseDatabase.getInstance().getReference();
    }

    public void DoLogIN(String username, String password) {

        if(username.isEmpty() || password.isEmpty())
        {
            my_contorol.throwNote("bad password or usrname");
        }
        else
        {
            ValueEventListener postListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.d("try12","Asdasdsa");
                    // Get Post object and use the values to update the UI
//                    if (!dataSnapshot.hasChild(username)) {
//                        my_contorol.failLogin();
//                    } else {
                        try {
                            User temp_user = dataSnapshot.getValue(User.class);
                            if (!temp_user.getPassword().equals(password)) {
                                my_contorol.throwNote("bad password or usrname");
                            } else {
                                my_contorol.succesLogin(temp_user);
                            }
                        }
                        catch (Exception e)
                        {
                            my_contorol.throwNote("bad password or usrname");
                        }
//                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w("ds", "loadPost:onCancelled", databaseError.toException());
                }
            };
            try {
                this.my_bd.child("users").child(username).addListenerForSingleValueEvent(postListener);
            }
            catch (Exception e){
                my_contorol.throwNote("bad password or usrname");
            }
        }
    }
}
