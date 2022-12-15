package com.example.supercheap;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MyAccountActivity extends BaseWithBarActivity {

    MyAccountController my_conntrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        this.my_conntrol = new MyAccountController(this);
        ((EditText)findViewById(R.id.update_first_name)).setText(user.getFirst_name());
        ((EditText)findViewById(R.id.update_last_name)).setText(user.getLast_name());
        ((EditText)findViewById(R.id.update_email)).setText(user.getEmail());
        ((EditText)findViewById(R.id.update_city)).setText(user.getCity());
        ((EditText)findViewById(R.id.update_date)).setText(user.getBirth_date());
        if(user.getGender().equals("Male")) {
            ((RadioButton) findViewById(R.id.MaleButton)).setChecked(true);
        }
        else {
            ((RadioButton) findViewById(R.id.FemaleButton)).setChecked(true);
        }

    }

    public void throwNote(String content)
    {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    public void updateUser(View v)
    {
//        String first_name = ((EditText)findViewById(R.id.update_first_name)).getText().toString();
//        String last_name = ((EditText)findViewById(R.id.update_last_name)).getText().toString();
//        String email = ((EditText)findViewById(R.id.update_email)).getText().toString();
//        String password = ((EditText)findViewById(R.id.update_password)).getText().toString();
//        String city = ((EditText)findViewById(R.id.update_city)).getText().toString();
//        String birth_date = ((EditText)findViewById(R.id.update_date)).getText().toString();
//        boolean male = ((RadioButton)findViewById(R.id.MaleButton)).isChecked();
//        boolean female = ((RadioButton)findViewById(R.id.FemaleButton)).isChecked();
//        String super_name = ((EditText)findViewById(R.id.update_super_name)).getText().toString();
//        String super_city = ((EditText)findViewById(R.id.update_super_city)).getText().toString();
//        }
//
//        controller.processingNewUser(first_name, last_name, email, username, password, city, birth_date, male, female, is_manager_yes, is_manager_no, super_name, super_city);
    }
}