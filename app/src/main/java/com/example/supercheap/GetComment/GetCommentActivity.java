package com.example.supercheap.GetComment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.CreateCart.CreateCart;
import com.example.supercheap.R;

import java.util.Locale;

public class GetCommentActivity extends BaseWithBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_comment);
    }
    public void show(View v){
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