package com.example.supercheap.DisplayCheapestSupers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.supercheap.R;

public class SuperDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_details);

        Intent intent = this.getIntent();
        if(intent != null){
            String name = intent.getStringExtra("name");
            String missing = intent.getStringExtra("missing");
            String subs = intent.getStringExtra("subs");
            String total_price = intent.getStringExtra("total_price");

            ((TextView)findViewById(R.id.super_name_dis)).setText(name);
            ((TextView)findViewById(R.id.missing_dis)).setText(missing);
            ((TextView)findViewById(R.id.subs_dis)).setText(subs);
            ((TextView)findViewById(R.id.total_price_dis)).setText(total_price);

        }
    }
}