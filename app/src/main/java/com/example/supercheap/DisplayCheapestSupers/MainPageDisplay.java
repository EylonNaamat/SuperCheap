package com.example.supercheap.DisplayCheapestSupers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supercheap.BaseActivity;
import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.Classes.Comment;
import com.example.supercheap.Classes.User;
import com.example.supercheap.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainPageDisplay extends BaseWithBarActivity {
    ListView list_view;
    DisplaySuperController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_display);

        list_view = (ListView) findViewById(R.id.listview);

        Intent i = this.getIntent();
        User user = (User) i.getParcelableExtra("user1");
        String city = i.getStringExtra("city");
        HashMap<String, String> item_list = (HashMap<String, String>)i.getSerializableExtra("item_list");
        controller = new DisplaySuperController(this, item_list);
        controller.fillSupers(city, item_list);

//        String city = "Mevasseret";
//        HashMap<String, String> item_list = new HashMap<>();
//        item_list.put("tuna", "fill");
//        controller = new DisplaySuperController(this, item_list);
//        controller.fillSupers(city);
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

    // fill func

    // showing the list to the user
    public void showSupers(ArrayList<SuperDisplay> supers){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();

                ListAdapter listAdapter = new ListAdapter(context, supers);
                list_view.setAdapter(listAdapter);
                list_view.setClickable(true);
                list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(MainPageDisplay.this, SuperDetails.class);
                        intent.putExtra("name", supers.get(i).getSuper_name());
                        intent.putExtra("city", supers.get(i).getCity());
                        intent.putExtra("missing", supers.get(i).getMissing_items());
                        intent.putExtra("subs", supers.get(i).getSubstitute_item());
                        intent.putExtra("total_price", supers.get(i).getTotal_price());
                        intent.putExtra("num_comments", supers.get(i).getNum_comments());
                        intent.putExtra("rating", supers.get(i).getGrade());
                        startActivity(intent);
                    }
                });
            }
        });

    }
}