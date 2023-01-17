package com.example.supercheap.Manager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.R;

public class ManagerPage extends BaseWithBarActivity {
    ControllerManager MController= new ControllerManager(this);
//    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_page);
//        user= (User) getIntent().getSerializableExtra("user");

    }

    public void throwNote(String content){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Toast.makeText(context, content, Toast.LENGTH_LONG).show();
            }
        });    }
    public void insert(View buttonEnterPrice ) {
        EditText itemName = findViewById(R.id.Item_Name);
        EditText price = findViewById(R.id.value_item);
        EditText company = findViewById(R.id.Company_Name);

        MController.ValidInput(String.valueOf(itemName.getText()), (price.getText().toString()), company.getText().toString(), user);
    }


}