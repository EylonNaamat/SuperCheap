package com.example.supercheap;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

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
    private FirebaseDatabase firebasedatabase;
    private DatabaseReference databasereference;
    private User user;
    private SignUpController controller;
    final static  String DATE_FORMAT = "dd/MM/yyyy";

    public SignUpModel(SignUpController controller){
        this.controller = controller;
    }

    public String dataValidation(String first_name, String last_name, String email, String username, String password, String city, String birth_date, boolean male, boolean female, boolean yes_manager, boolean no_manager ,String super_id){
        if(isEmpty(first_name) || isEmpty(last_name) || isEmpty(email) || isEmpty(username) || isEmpty(password) || isEmpty(city) || isEmpty(birth_date)){
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
        if(yes_manager && isEmpty(super_id)){
            return "you need to add super id";
        }
        if(!isDateValid(birth_date)){
            return "Date isnt valid";
        }
        return "good";
    }

    public boolean isEmpty(String field){
        return TextUtils.isEmpty(field);
    }

    public void insertUserToFb(String first_name, String last_name, String email, String username, String password, String city, String birth_date, String gender, boolean is_manager, String super_id){
        this.firebasedatabase = FirebaseDatabase.getInstance();
        this.databasereference = firebasedatabase.getReference();
        this.user = new User();

        this.user.setFirst_name(first_name);
        this.user.setLast_name(last_name);
        this.user.setEmail(email);
        this.user.setUsername(username);
        this.user.setPassword(password);
        this.user.setCity(city);
        this.user.setBirth_data(birth_date);
        this.user.setGender(gender);
        this.user.setIs_manager(is_manager);
        this.user.setSuper_id(super_id);
        databasereference = databasereference.child("users");

        databasereference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("bdika2", "enter read");
                if(snapshot.hasChild(username)){
                    Log.d("bdika2", "exist");
                    controller.failCreation("user already exists");
                }else{
                    Log.d("bdika2", "doesnt exist");

                    databasereference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databasereference.child(username).setValue(user);
                            controller.successCreation(username);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.d("bdika2", "dont write");
                            controller.failCreation("Failed to write to firebase");
                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("bdika2", "dont read");
                controller.failCreation("Failed to read from firebase");
            }
        });

    }

//    public void isUserExist(String username){
//        this.firebasedatabase = FirebaseDatabase.getInstance();
//        this.databasereference = firebasedatabase.getReference();
//        boolean [] ans = {true};
//        databasereference = databasereference.child("users");
//        databasereference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.hasChild(username)){
//                    ans[0] = true;
//                }else{
//                    ans[0] = false;
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        return ans[0];
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
}
