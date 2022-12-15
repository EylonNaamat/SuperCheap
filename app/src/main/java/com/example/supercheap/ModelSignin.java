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

    public ModelSignin(ControllerSignin contoroler) {
        this.my_contorol = contoroler;
        this.my_bd = FirebaseDatabase.getInstance().getReference();

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
                    Log.d("try12","Asdasdsa");
                    // Get Post object and use the values to update the UI
//                    if (!dataSnapshot.hasChild(username)) {
//                        my_contorol.failLogin();
//                    } else {
                        User temp_user = dataSnapshot.getValue(User.class);
                        if (!temp_user.getPassword().equals(password)) {
                            my_contorol.failLogin();
                        } else {
                            my_contorol.succesLogin(temp_user);
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
                this.my_bd.child("users").child(username).addValueEventListener(postListener);
            }
            catch (Exception e){
                my_contorol.failLogin();
            }
        }
    }
}
