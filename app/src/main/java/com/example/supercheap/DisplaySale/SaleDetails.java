package com.example.supercheap.DisplaySale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.supercheap.R;

public class SaleDetails extends AppCompatActivity {
    private String sale_name;
    private String item;
    private String company;
    private String quantity;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_details);

        Intent intent = this.getIntent();
        if(intent != null){
            this.sale_name = intent.getStringExtra("sale_name");
            Log.d("test_comment", this.sale_name);
            this.item = intent.getStringExtra("item");
            Log.d("test_comment", this.item);
            this.company = intent.getStringExtra("company");
            Log.d("test_comment", this.company);
            this.quantity = intent.getStringExtra("quantity");
            Log.d("test_comment", this.quantity);
            this.price = intent.getStringExtra("price");
            Log.d("test_comment", this.price);


            ((TextView)findViewById(R.id.sale_name_deatil)).setText(this.sale_name);
            ((TextView)findViewById(R.id.item_deatil)).setText("Item: " + this.item);
            ((TextView)findViewById(R.id.company_deatil)).setText("Company: " + this.company);
            ((TextView)findViewById(R.id.quantity_deatil)).setText("Quantity: " + this.quantity);
            ((TextView)findViewById(R.id.price_value_deatil)).setText(this.price + " ₪");
        }
    }
}