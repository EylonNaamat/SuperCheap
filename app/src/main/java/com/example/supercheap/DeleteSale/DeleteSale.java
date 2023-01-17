package com.example.supercheap.DeleteSale;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.Manager.ControllerManager;
import com.example.supercheap.R;

public class DeleteSale extends BaseWithBarActivity {
    DeleteSaleController DController= new DeleteSaleController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_sale);

    }

    public void throwNote(String content){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Toast.makeText(context, content, Toast.LENGTH_LONG).show();
            }
        });    }
    public void Delete(View buttonEnterPrice ) {
        EditText SaleName = findViewById(R.id.Sale_Name_Delete);

        DController.ValidInput(String.valueOf(SaleName.getText()), user);

    }

}