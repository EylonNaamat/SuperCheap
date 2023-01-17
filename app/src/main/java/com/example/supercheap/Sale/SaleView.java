package com.example.supercheap.Sale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.R;

public class SaleView extends BaseWithBarActivity {
    SaleController saleController = new SaleController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
    }

    public void throwNote(String content) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Toast.makeText(context, content, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void update(View buttonSale) {
        EditText SaleName =findViewById(R.id.sale_name);
        EditText ItemSaleName = findViewById(R.id.Item_Sale_name);
        EditText company = findViewById(R.id.sale_company_name);
        EditText SaleQuantity = findViewById(R.id.quantity_sale);
        EditText PriceSale = findViewById(R.id.PriceSaleInput);
        saleController.ValidInput(String.valueOf(ItemSaleName.getText()), (company.getText().toString()), SaleQuantity.getText().toString(), PriceSale.getText().toString(),SaleName.getText().toString(), user);
    }
}