package com.example.supercheap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GreetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        String msg = username + " Thanks for signing up!";

        ((EditText)findViewById(R.id.Greets)).setText(msg);
    }

    public void returnToLogin(View v){
//        Intent i = new Intent(this, ViewSignin.class);
//        startActivity(i);
    }


}