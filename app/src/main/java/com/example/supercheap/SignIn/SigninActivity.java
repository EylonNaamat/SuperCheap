package com.example.supercheap.SignIn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.BaseActivity;
import com.example.supercheap.CreateCart.CreateCart;
import com.example.supercheap.R;
import com.example.supercheap.SignUp.SignUpActivity;
import com.example.supercheap.Classes.User;

public class SigninActivity extends BaseActivity {

    ControllerSignin my_contoler = new ControllerSignin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sighin);
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

    public void signIn(View button_sigh_in) {
        EditText username = (EditText) findViewById(R.id.username_input);
        EditText password = (EditText) findViewById(R.id.password_input);
        my_contoler.tryLogin(username.getText().toString() , password.getText().toString());
    }


    public void signInSucces(User temp_user) {

        Intent intent = new Intent(this, CreateCart.class);
        intent.putExtra("user1",temp_user);
        startActivity(intent);
        overridePendingTransition(0,0);

    }

    public void reset(View button_reset)
    {
        ((EditText) (findViewById(R.id.username_input))).setText(null);
        ((EditText) (findViewById(R.id.password_input))).setText(null);
    }

    public void signUp(View button_sigh_up)
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);

    }

}