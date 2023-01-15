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
import java.util.UUID;

public class SignUpModel {
    private DatabaseReference databasereference;
    private User user;
    private Super new_super;
    private SignUpController controller;
    private SignUpActivity view;
    final static String DATE_FORMAT = "dd/MM/yyyy";

    public SignUpModel(SignUpActivity view, SignUpController controller) {
        this.view = view;
        this.controller = controller;
        this.user = new User();
        this.new_super = new Super();
    }

    public String dataValidation(String first_name, String last_name, String email, String username, String password, String city, String birth_date, boolean male, boolean female, boolean yes_manager, boolean no_manager, String super_name, String super_city) {
        if (first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || city.isEmpty() || birth_date.isEmpty()) {
            return "you forget to fill some fields";
        }
        if (male && female) {
            return "you filled both male and female";
        }
        if (!(male || female)) {
            return "you didnt select gender";
        }
        if (yes_manager && no_manager) {
            return "you filled both manager and not manager";
        }
        if (!(yes_manager || no_manager)) {
            return "you didnt select whether you are manager or not";
        }
        if (yes_manager && super_name.isEmpty()) {
            return "you need to add super name";
        }
        if (yes_manager && super_city.isEmpty()) {
            return "you need to add super ciy";
        }
        if (!isDateValid(birth_date)) {
            return "Date isnt valid";
        }
        return "good";
    }

    public boolean isDateValid(String date) {
        try {
            DateFormat dateformat = new SimpleDateFormat(DATE_FORMAT);
            dateformat.setLenient(false);
            dateformat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public void checkUserInfo(String first_name, String last_name, String email, String username, String password, String city, String birth_date, boolean male, boolean female, boolean yes_manager, boolean no_manager, String super_name, String super_city) {
        String gender = "";
        String super_id = "";
        String errors = dataValidation(first_name, last_name, email, username, password, city, birth_date, male, female, yes_manager, no_manager, super_name, super_city);

        if (yes_manager) {
            super_id = UUID.randomUUID().toString();
            this.new_super.setSuper_ID(super_id);
            this.new_super.setSuper_name(super_name);
            this.new_super.setSuper_city(super_city);
            this.new_super.setSuper_rating(2.5);
            this.new_super.setComments_size(0);
        }

        if (male) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        if (!errors.equals("good")) {
            this.view.promptMsg(errors);
        } else {
            // return to controller
            this.user = new User(first_name, last_name, email, username, password, city, birth_date, gender, yes_manager, super_id);
            this.controller.sendUser(this.user, this.new_super);
        }
    }
}
