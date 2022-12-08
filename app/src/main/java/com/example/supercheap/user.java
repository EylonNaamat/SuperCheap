package com.example.supercheap;

import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class user {
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String city;
    private int year;
    private int month;
    private int day;
    private int gender;

    public user(String first_name, String last_name, String username, String password, String city, int year, int month, int day, int gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.city = city;
        this.year = year;
        this.month = month;
        this.day = day;
        this.gender = gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

//    public Map<String,Object> insertToFB(FirebaseDatabase db){
//
//        Map<String,Object> user = new HashMap<>();
//        user.put("first_name", this.first_name);
//        user.put("last_name", this.last_name);
//        user.put("password", this.password);
//        user.put("city", this.city);
//        user.put("year", this.year);
//        user.put("month", this.month);
//        user.put("day", this.day);
//        user.put("gender", this.gender);
//
//
//
//
//        return user;
//
//
////        db.getReference().child("users").child(this.username).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
////            @Override
////            public void onSuccess(DocumentReference documentReference) {
////                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
////            }
////        }).addOnFailureListener(new OnFailureListener() {
////            @Override
////            public void onFailure(@NonNull Exception e) {
////                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();
////            }
////        });
//    }
}