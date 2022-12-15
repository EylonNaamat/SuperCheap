package com.example.supercheap.SignUp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.supercheap.Classes.Super;
import com.example.supercheap.Classes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class SignUpModel {
    private DatabaseReference databasereference;
    private User user;
    private Super new_super;
    private SignUpController controller;
    final static String DATE_FORMAT = "dd/MM/yyyy";

    public SignUpModel(SignUpController controller){
        this.controller = controller;
        this.user = new User();
        this.new_super = new Super();
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
        DatabaseReference curr_databasereference = databasereference.child("users");
        curr_databasereference.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    try{
                        task.getResult().getValue(User.class).getUsername();
                        controller.failCreation("user already exists");
                    }catch (Exception e){
                        user = new User(first_name, last_name, email, username, password, city, birth_date, gender, is_manager, super_id);
                        insertUserToFB();
                        if(is_manager){
                            HashMap<String, HashMap<String, Double>> products = new HashMap<>(new HashMap<>());
                            new_super = new Super(super_id, super_name, super_city, products);
                            insertSuperToFB();
                        }
                        controller.successCreation(user);
                    }
                }
            }
        });
    }

    public void insertUserToFB(){
        Log.d("bdika2", "enter insert");
        Log.d("bdika2", "user created");
        this.databasereference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference curr_databasereference = databasereference.child("users");

        curr_databasereference.child(this.user.getUsername()).setValue(this.user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        controller.goodCreation("inserted user successfully");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        controller.failCreation("insertion gone wrong");
                    }
                });
    }

    public void insertSuperToFB(){
        this.databasereference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference curr_databasereference = databasereference.child("Supers");
        curr_databasereference.child(this.new_super.getSuper_ID()).setValue(this.new_super);
    }
}
