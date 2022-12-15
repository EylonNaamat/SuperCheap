package com.example.supercheap.SignUp;

import android.util.Log;

import com.example.supercheap.Classes.User;

import java.util.UUID;

public class SignUpController {
    private SignUpActivity view;
    private SignUpModel model;

    public SignUpController(SignUpActivity view) {
        this.view = view;
        this.model = new SignUpModel(this);
    }

    public void processingNewUser(String first_name, String last_name, String email, String username, String password, String city, String birth_date, boolean male, boolean female, boolean yes_manager, boolean no_manager, String super_name, String super_city){
        boolean valid_user = true;
        String gender = "";
        String super_id = "";
        if(yes_manager){
            super_id = UUID.randomUUID().toString();
        }
        String errors = model.dataValidation(first_name, last_name, email, username, password, city, birth_date, male, female, yes_manager, no_manager, super_name, super_city);

        if(!errors.equals("good")){
            valid_user = false;
        }
        if(male){
            gender = "Male";
        }else{
            gender = "Female";
        }

        if(valid_user){
            model.isUserExist(first_name, last_name, email, username, password, city, birth_date, gender, yes_manager, super_id, super_name, super_city);
        }else{
            view.promptError(errors);
        }
    }

    public void successCreation(User user){
        view.greet(user);
    }

    public void failCreation(String error){
        view.promptError(error);
        Log.d("testtest", "controller fail ");
    }

    public void goodCreation(String msg){
        view.promptSuccess(msg);
    }


}
