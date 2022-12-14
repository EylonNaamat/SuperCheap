package com.example.supercheap.Greet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.supercheap.BaseActivity;
import com.example.supercheap.R;
import com.example.supercheap.SignIn.SigninActivity;

public class GreetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        String super_id = bundle.getString("super_id");
        String msg = username + " Thanks for signing up!";
        String super_id_msg = "Your super id is " + super_id;

        ((EditText)findViewById(R.id.Greets)).setText(msg);
        if(!super_id.isEmpty()){
            ((EditText)findViewById(R.id.supId)).setText(super_id_msg);
        }
    }

    public void returnToLogin(View v){
        Intent i = new Intent(this, SigninActivity.class);
        startActivity(i);
    }


}