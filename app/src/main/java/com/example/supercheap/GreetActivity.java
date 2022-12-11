package com.example.supercheap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class GreetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);

        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String username = bundle.getString("username");
        String msg = "Hey " + username + " welcome to our family!";

        ((EditText)findViewById(R.id.Greet)).setText(msg);
    }


}