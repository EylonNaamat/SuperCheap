package com.example.supercheap;

import java.util.ArrayList;


public class User {
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;
    private String city;
    private String birth_data;
    private String gender;
    private boolean is_manager;
    private String super_id;

    public User(){

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getBirth_data() {
        return birth_data;
    }

    public void setBirth_data(String birth_data) {
        this.birth_data = birth_data;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isIs_manager() {
        return is_manager;
    }

    public void setIs_manager(boolean is_manager) {
        this.is_manager = is_manager;
    }

    public String getSuper_id() {
        return super_id;
    }

    public void setSuper_id(String super_id) {
        this.super_id = super_id;
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