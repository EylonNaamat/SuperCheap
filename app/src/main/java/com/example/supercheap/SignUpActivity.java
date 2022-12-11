package com.example.supercheap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void createUser(View v){
        String first_name = ((EditText)findViewById(R.id.FirstName)).getText().toString();
        String last_name = ((EditText)findViewById(R.id.LastName)).getText().toString();
        String email = ((EditText)findViewById(R.id.Email)).getText().toString();
        String username = ((EditText)findViewById(R.id.Username)).getText().toString();
        String password = ((EditText)findViewById(R.id.Password)).getText().toString();
        String city = ((EditText)findViewById(R.id.City)).getText().toString();
        String birth_date = ((EditText)findViewById(R.id.Date)).getText().toString();
        boolean male = ((RadioButton)findViewById(R.id.MaleButton)).isChecked();
        boolean female = ((RadioButton)findViewById(R.id.FemaleButton)).isChecked();
        boolean is_manager_yes = ((RadioButton)findViewById(R.id.YesManager)).isChecked();
        boolean is_manager_no = ((RadioButton)findViewById(R.id.NoManager)).isChecked();
        String super_id = ((EditText)findViewById(R.id.SuperId)).getText().toString();


        SignUpController controller = new SignUpController(this);
        controller.processingNewUser(first_name, last_name, email, username, password, city, birth_date, male, female, is_manager_yes, is_manager_no, super_id);
    }

    public void greet(String username){
        Intent i = new Intent(this, GreetActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        i.putExtras(bundle);
        startActivity(i);
    }

    public void promptError(String errors){
        Toast.makeText(this, errors, Toast.LENGTH_LONG).show();
    }


}