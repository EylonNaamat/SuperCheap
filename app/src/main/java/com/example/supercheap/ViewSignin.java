package com.example.supercheap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class ViewSignin extends AppCompatActivity {

    ControllerSignin my_contoler = new ControllerSignin(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sighin);

    }

    public void throwNote(String content)
    {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    public void sighIn(View button_sigh_in) {
        EditText username = (EditText) findViewById(R.id.username_input);
        EditText password = (EditText) findViewById(R.id.password_input);
        my_contoler.tryLogin(username.getText().toString() , password.getText().toString());
    }

    public void sighInSucces() {
        Toast.makeText(this, "sighInSucces", Toast.LENGTH_LONG).show();
    }

    public void reset(View button_reset)
    {
        ((EditText) (findViewById(R.id.username_input))).setText(null);
        ((EditText) (findViewById(R.id.password_input))).setText(null);
    }

    public void sighUp(View button_sigh_up)
    {
    // change page on sigh up

    }

}