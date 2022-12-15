package com.example.supercheap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MySuperActivity extends BaseWithBarActivity {
    MySuperController my_conntrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_super);

        my_conntrol = new MySuperController(this);
        my_conntrol.checkSuperDetails();
    }

    public void setSuperName(String super_name) {
        ((EditText) findViewById(R.id.update_super_name)).setText(super_name);
    }
    public void setSuperCity(String super_city) {
        ((EditText) findViewById(R.id.update_super_city)).setText(super_city);
    }

    public void throwNote(String content)
    {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    public void updateSuper(View v)
    {

    }
}