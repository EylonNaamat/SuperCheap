package com.example.supercheap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.databinding.ActivityManagerPageBinding;

public class ManagerPage extends BaseWithBarActivity  {
    ControllerManager MController= new ControllerManager(this);
//    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_page);
//        user= (User) getIntent().getSerializableExtra("user");

    }

    public void throwNote(String content){
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }
    public void insert(View buttonEnterPrice ) {
        EditText itemName = findViewById(R.id.Item_Name);
        EditText price = findViewById(R.id.value_item);
        EditText company = findViewById(R.id.Company_Name);

        MController.TryInsert(String.valueOf(itemName.getText()), (price.getText().toString()), company.getText().toString(), user);
    }
    public void update(View buttonSale)
    {
     EditText SaleName=findViewById(R.id.Sale_name);
     EditText company=findViewById(R.id.sale_company_name);
     EditText SaleQuantity= findViewById(R.id.quantity_sale);
     EditText PriceSale= findViewById(R.id.PriceSaleInput);
     MController.TryUpdate(SaleName.getText().toString(),SaleQuantity.getText().toString(), PriceSale.getText().toString(),company.getText().toString(),user);
    }

}