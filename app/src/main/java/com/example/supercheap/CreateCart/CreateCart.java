package com.example.supercheap.CreateCart;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.DisplayCheapestSupers.MainPageDisplay;
import com.example.supercheap.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class CreateCart extends BaseWithBarActivity {
    CreatCartController CController = new CreatCartController(this);
    Button insert;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> send_arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    EditText comany_name;
    EditText quantity;
    EditText item_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cart);
        this.comany_name = findViewById(R.id.company_item_name);
        this.quantity = findViewById(R.id.add_quantity);
        this.item_name = findViewById(R.id.Cart_Item);


        ListView listView = (ListView) findViewById(R.id.my_list);
        insert = findViewById(R.id.insert);
        adapter = new MyListAdapter(getApplicationContext(), R.layout.list_item, arrayList, send_arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CreateCart.this, "" + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
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

    public void AddToList(View v) {
        EditText item_name = findViewById(R.id.Cart_Item);
        EditText company_name = findViewById(R.id.company_item_name);
        EditText quantity = findViewById(R.id.add_quantity);

        CController.ValidInput(item_name.getText().toString(), company_name.getText().toString(), quantity.getText().toString());

    }

    public void ShowCheaper(View v) {
        EditText my_city_name = findViewById(R.id.Cart_City);

        AlertDialog.Builder add_dial = new AlertDialog.Builder(CreateCart.this);
        add_dial.setMessage("Are you sure? ").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CController.validCity(arrayList, my_city_name.getText().toString(), user);

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

    public void find(String city) {

        HashMap<String, String> myHash = CController.convertArrayListToHash(send_arrayList);
        Log.d("hash", myHash.keySet().toString());
        Log.d("hashval", myHash.values().toString());

        Intent intent = new Intent(this, MainPageDisplay.class);
        intent.putExtra("user1", user);
        intent.putExtra("item_list", myHash);
        intent.putExtra("city", city);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void resetText() {
        this.comany_name.setText("");
        this.item_name.setText("");
        this.quantity.setText("");
    }

    public void add(String item, String company_name, String quantity) {
        resetText();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                send_arrayList.add(item + "_" + quantity + "," + company_name);
                arrayList.add(item + "," + company_name + ",quantity=" + quantity);
                adapter.notifyDataSetChanged();


            }
        });


    }


}