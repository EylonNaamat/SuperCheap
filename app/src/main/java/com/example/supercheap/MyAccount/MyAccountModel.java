package com.example.supercheap.MyAccount;

import com.example.supercheap.Classes.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyAccountModel {
    private MyAccountController my_control;
    private MyAccountActivity my_view;
    final String DATE_FORMAT = "dd/MM/yyyy";

    public MyAccountModel(MyAccountController temp_con,MyAccountActivity temp_view)
    {
        this.my_control = temp_con;
        this.my_view = temp_view;
    }
    //check if date is good
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
    //check the details are good form
    public void checkuserdetails(String first_name,String last_name,String email, String password,String city,String birth_date,boolean male,boolean female)
    {
        if (first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || password.isEmpty() || city.isEmpty() || birth_date.isEmpty()) {
            my_view.throwNote( "you forget to fill some fields");
        }
        else if (male && female) {
            my_view.throwNote( "you filled both male and female");
        }
        else if (!(male || female)) {
            my_view.throwNote( "you didnt select gender");
        }
        else if (!isDateValid(birth_date)) {
            my_view.throwNote( "Date isnt valid");
        }
        else {
            if(male) {
                my_control.updateUserindata(first_name, last_name, email, password, city, birth_date, "Male");
            }
            else{
                my_control.updateUserindata(first_name, last_name, email, password, city, birth_date, "Female");
            }
        }
    }

}
