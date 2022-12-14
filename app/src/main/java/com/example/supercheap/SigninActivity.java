package com.example.supercheap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends BaseActivity {

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

        User temp_user = new User("1","2","3","4","5","6","7","8",true,"10");
        Intent intent = new Intent(this,ManagerPage.class);
        intent.putExtra("user1",temp_user);
        startActivity(intent);
        overridePendingTransition(0,0);

    }

    public void reset(View button_reset)
    {
        ((EditText) (findViewById(R.id.username_input))).setText(null);
        ((EditText) (findViewById(R.id.password_input))).setText(null);
    }

    public void sighUp(View button_sigh_up)
    {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);

    }

}