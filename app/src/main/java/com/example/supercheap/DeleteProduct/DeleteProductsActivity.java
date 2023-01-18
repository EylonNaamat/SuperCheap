package com.example.supercheap.DeleteProduct;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.R;

public class DeleteProductsActivity extends BaseWithBarActivity {
    DeleteController DController = new DeleteController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_products);

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

    public void Delete(View buttonEnterPrice) {
        EditText itemName = findViewById(R.id.Item_Name_Delete);
        EditText company = findViewById(R.id.Company_Name_Delete);
        AlertDialog.Builder add_dial = new AlertDialog.Builder(DeleteProductsActivity.this);
        add_dial.setMessage("Remove Item? ").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DController.ValidInput(String.valueOf(itemName.getText()), company.getText().toString(), user);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = add_dial.create();
        alert.setTitle("Finish Cart");
        alert.show();

    }

}