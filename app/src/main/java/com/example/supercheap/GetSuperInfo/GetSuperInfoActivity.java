package com.example.supercheap.GetSuperInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.CreateCart.CreateCart;
import com.example.supercheap.DisplayComment.DisplayCommentView;
import com.example.supercheap.DisplaySale.DisplaySaleView;
import com.example.supercheap.R;

public class GetSuperInfoActivity extends BaseWithBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_super_info);
    }
    // get the informtion from the page and pass the page to the show page for comments
    public void show_comments(View v){
        String super_name = ((EditText) findViewById(R.id.get_commen_super_name_input)).getText().toString();
        String super_city = ((EditText) findViewById(R.id.get_commen_super_city_input)).getText().toString();
        super_name = super_name.toLowerCase();
        super_city = super_city.toLowerCase();

        Intent intent = new Intent(this, DisplayCommentView.class);

        intent.putExtra("user1",this.user);
        intent.putExtra("super_name",super_name);
        intent.putExtra("super_city",super_city);

        startActivity(intent);
        overridePendingTransition(0,0);
    }
    // get the informtion from the page and pass the page to the show page for sales
    public void show_saless(View v){
        String super_name = ((EditText) findViewById(R.id.get_commen_super_name_input)).getText().toString();
        String super_city = ((EditText) findViewById(R.id.get_commen_super_city_input)).getText().toString();
        super_name = super_name.toLowerCase();
        super_city = super_city.toLowerCase();

        Intent intent = new Intent(this, DisplaySaleView.class);

        intent.putExtra("user1",this.user);
        intent.putExtra("super_name",super_name);
        intent.putExtra("super_city",super_city);

        startActivity(intent);
        overridePendingTransition(0,0);
    }
}