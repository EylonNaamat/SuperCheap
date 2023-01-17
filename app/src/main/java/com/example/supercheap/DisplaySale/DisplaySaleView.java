package com.example.supercheap.DisplaySale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.supercheap.DisplayComment.CommentDetails;
import com.example.supercheap.DisplayComment.CommentDisplay;
import com.example.supercheap.DisplayComment.DisplayCommentController;
import com.example.supercheap.DisplayComment.DisplayCommentView;
import com.example.supercheap.DisplayComment.ListAdapterComment;
import com.example.supercheap.R;

import java.util.ArrayList;

public class DisplaySaleView extends AppCompatActivity {
    private String super_name;
    private String super_city;
    private DisplaySaleController controller;
    ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sale_view);

        list_view = (ListView) findViewById(R.id.salelistview);

        Intent intent = this.getIntent();

        this.super_name = intent.getStringExtra("super_name");
        this.super_city = intent.getStringExtra("super_city");

        this.controller= new DisplaySaleController(this);
        this.controller.init(this.super_name, this.super_city);
    }

    public void promptMsg(String msg){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showSales(ArrayList<SalesDisplay> sales){
        Log.d("test_comment", "enter showe comments");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Log.d("test_comment", "enter showe comments 2");

                ListAdapterSale listAdapter = new ListAdapterSale(context, sales);
                list_view.setAdapter(listAdapter);
                list_view.setClickable(true);
                list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Log.d("test_comment", "enter click");
                        Log.d("test_comment", ("i is " + i));

                        Intent intent = new Intent(DisplaySaleView.this, SaleDetails.class);

                        intent.putExtra("sale_name", sales.get(i).getSale_name());
                        Log.d("test_comment", sales.get(i).getSale_name());
                        intent.putExtra("item", sales.get(i).getItem());
                        Log.d("test_comment", sales.get(i).getItem());
                        intent.putExtra("company", sales.get(i).getCompany());
                        Log.d("test_comment", sales.get(i).getCompany());
                        intent.putExtra("quantity", sales.get(i).getQuantity());
                        Log.d("test_comment", sales.get(i).getQuantity());
                        intent.putExtra("price", sales.get(i).getPrice());
                        Log.d("test_comment", sales.get(i).getPrice());
                        Log.d("test_comment", "finish click");
                        startActivity(intent);
                    }
                });
            }
        });
    }

    public void failToDisplay(){
        this.finish();
    }
}