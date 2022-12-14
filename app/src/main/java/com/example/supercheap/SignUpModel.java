package com.example.supercheap;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SignUpModel {
    private DatabaseReference databasereference;
    private User user;
    private SignUpController controller;
    final static String DATE_FORMAT = "dd/MM/yyyy";

    public SignUpModel(SignUpController controller){
        this.controller = controller;
        this.user = new User();
    }

    public String dataValidation(String first_name, String last_name, String email, String username, String password, String city, String birth_date, boolean male, boolean female, boolean yes_manager, boolean no_manager ,String super_name, String super_city){
        if(first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || city.isEmpty() || birth_date.isEmpty()){
            return "you forget to fill some fields";
        }
        if(male && female){
            return "you filled both male and female";
        }
        if(!(male || female)){
            return "you didnt select gender";
        }
        if(yes_manager && no_manager){
            return "you filled both manager and not manager";
        }
        if(!(yes_manager || no_manager)){
            return "you didnt select whether you are manager or not";
        }
        if(yes_manager && super_name.isEmpty()){
            return "you need to add super name";
        }
        if(yes_manager && super_city.isEmpty()){
            return "you need to add super ciy";
        }
        if(!isDateValid(birth_date)){
            return "Date isnt valid";
        }
        return "good";
    }

//    public boolean isEmpty(String field){
//        return TextUtils.isEmpty(field);
//    }

    public boolean isDateValid (String date){
        try{
            DateFormat dateformat = new SimpleDateFormat(DATE_FORMAT);
            dateformat.setLenient(false);
            dateformat.parse(date);
            return true;
        } catch(ParseException e){
            return false;
        }
    }

    public void isUserExist(String first_name, String last_name, String email, String username, String password, String city, String birth_date, String gender, boolean is_manager, String super_id, String super_name, String super_city){
        this.databasereference = FirebaseDatabase.getInstance().getReference();
        databasereference = databasereference.child("users");


        databasereference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("bdika2", "enter read");
                if(snapshot.hasChild(username)){
                    Log.d("bdika2", "exist");
                    controller.failCreation("user already exists");
                }else{
                    User new_user = new User(first_name, last_name, email, username, password, city, birth_date, gender, is_manager, super_id);
                    insertUserToFB(new_user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("bdika2", "dont read");
                controller.failCreation("Failed to read from firebase");
            }
        });

    }

    public void insertUserToFB(User new_user){
        Log.d("bdika2", "enter insert");
        this.user = new User(new_user);
        Log.d("bdika2", "user created");


        databasereference.child(this.user.getUsername()).setValue(this.user);
        Log.d("bdika2", "user inserted");
        controller.successCreation(this.user.getUsername(), this.user.getSuper_id());
        Log.d("bdika2", "new page");
    }
}
