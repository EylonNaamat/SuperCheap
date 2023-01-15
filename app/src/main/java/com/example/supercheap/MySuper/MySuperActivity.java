package com.example.supercheap.MySuper;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.R;

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
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Toast.makeText(context, content, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void updateSuper(View v)
    {
        String super_name= ((EditText)findViewById(R.id.update_super_name)).getText().toString();
        String super_city = ((EditText)findViewById(R.id.update_super_city)).getText().toString();

        my_conntrol.updateUser(super_name, super_city);
    }
}