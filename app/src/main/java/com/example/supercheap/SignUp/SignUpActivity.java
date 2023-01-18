package com.example.supercheap.SignUp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supercheap.BaseActivity;
import com.example.supercheap.Greet.GreetActivity;
import com.example.supercheap.R;
import com.example.supercheap.Classes.User;

public class SignUpActivity extends BaseActivity {

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
        String super_name = "";
        String super_city = "";
        if(is_manager_yes){
            super_name = ((EditText)findViewById(R.id.SuperName)).getText().toString();
            super_city = ((EditText)findViewById(R.id.SuperCity)).getText().toString();
        }

        SignUpController controller = new SignUpController(this);
        controller.processingNewUser(first_name, last_name, email, username, password, city, birth_date, male, female, is_manager_yes, is_manager_no, super_name, super_city);
    }

    public void greet(User user){
        Intent i = new Intent(this, GreetActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("username", user.getUsername());
        bundle.putString("super_id", user.getSuper_id());
        i.putExtras(bundle);
        startActivity(i);
    }

    public void promptError(String errors){
        (Toast.makeText(this, errors, Toast.LENGTH_LONG)).show();
    }

    public void promptMsg(String msg){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void promptSuccess(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if(view.getId() == R.id.YesManager) {
            if (checked) {
                ((TextView) findViewById(R.id.SuperNameLabel)).setText("Super Name:");
                ((EditText) findViewById(R.id.SuperName)).setEnabled(true);
                ((TextView) findViewById(R.id.SuperCityLabel)).setText("Super City:");
                ((EditText) findViewById(R.id.SuperCity)).setEnabled(true);
            }
        }
        if(view.getId() == R.id.NoManager) {
            if (checked) {
                ((TextView) findViewById(R.id.SuperNameLabel)).setText("");
                ((EditText) findViewById(R.id.SuperName)).setEnabled(false);
                ((TextView) findViewById(R.id.SuperCityLabel)).setText("");
                ((EditText) findViewById(R.id.SuperCity)).setEnabled(false);
            }
        }
    }
}