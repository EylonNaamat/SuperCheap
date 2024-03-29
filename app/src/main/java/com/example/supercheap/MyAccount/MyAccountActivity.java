package com.example.supercheap.MyAccount;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.R;

public class MyAccountActivity extends BaseWithBarActivity {

    MyAccountController my_conntrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        this.my_conntrol = new MyAccountController(this);
        //set the user values in the screan
        ((TextView)findViewById(R.id.update_username)).setText(user.getUsername());
        ((EditText)findViewById(R.id.update_first_name)).setText(user.getFirst_name());
        ((EditText)findViewById(R.id.update_last_name)).setText(user.getLast_name());
        ((EditText)findViewById(R.id.update_password)).setText(user.getPassword());
        ((EditText)findViewById(R.id.update_email)).setText(user.getEmail());
        ((EditText)findViewById(R.id.update_city)).setText(user.getCity());
        ((EditText)findViewById(R.id.update_date)).setText(user.getBirth_date());
        //check if male ar female
        if(user.getGender().equals("Male")) {
            ((RadioButton) findViewById(R.id.MaleButton)).setChecked(true);
        }
        else {
            ((RadioButton) findViewById(R.id.FemaleButton)).setChecked(true);
        }

    }

    public void throwNote(String content)
    {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Toast.makeText(context, content, Toast.LENGTH_LONG).show();
            }
        });
    }
    //get user details and send it to the contorler
    public void updateUser(View v) {
        String first_name = ((EditText) findViewById(R.id.update_first_name)).getText().toString();
        String last_name = ((EditText) findViewById(R.id.update_last_name)).getText().toString();
        String email = ((EditText) findViewById(R.id.update_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.update_password)).getText().toString();
        String city = ((EditText) findViewById(R.id.update_city)).getText().toString();
        String birth_date = ((EditText) findViewById(R.id.update_date)).getText().toString();
        boolean male = ((RadioButton) findViewById(R.id.MaleButton)).isChecked();
        boolean female = ((RadioButton) findViewById(R.id.FemaleButton)).isChecked();

        my_conntrol.updateUser(first_name, last_name, email, password, city, birth_date, male, female);
    }
}