package com.example.supercheap.GetSuperInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.CreateCart.CreateCart;
import com.example.supercheap.R;

public class GetSuperInfoActivity extends BaseWithBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_super_info);
    }
    public void show_comments(View v){
        String super_name = ((EditText) findViewById(R.id.get_commen_super_name_input)).getText().toString();
        String super_city = ((EditText) findViewById(R.id.get_commen_super_city_input)).getText().toString();
        super_name = super_name.toLowerCase();
        super_city = super_city.toLowerCase();
        Intent intent = new Intent(this, CreateCart.class);
        intent.putExtra("user1",this.user);
        intent.putExtra("super_name",super_name);
        intent.putExtra("super_city",super_city);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    public void show_saless(View v){
        String super_name = ((EditText) findViewById(R.id.get_commen_super_name_input)).getText().toString();
        String super_city = ((EditText) findViewById(R.id.get_commen_super_city_input)).getText().toString();
        super_name = super_name.toLowerCase();
        super_city = super_city.toLowerCase();
        Intent intent = new Intent(this, CreateCart.class);
        intent.putExtra("user1",this.user);
        intent.putExtra("super_name",super_name);
        intent.putExtra("super_city",super_city);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}