package com.example.supercheap.DisplayCheapestSupers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supercheap.BaseActivity;
import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.Classes.User;
import com.example.supercheap.R;
import com.example.supercheap.databinding.ActivityMainBinding;

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

//        Intent i = this.getIntent();
//        if(i != null){
//            User user = user = (User) i.getParcelableExtra("user1");
//            String city = i.getStringExtra("city");
//            HashMap<String, String> item_list = (HashMap<String, String>)i.getSerializableExtra("item_list");
//            item_list.put("tuna", "fill");
//            controller = new DisplaySuperController(this, item_list);
//            controller.fillSupers(city);
//        }

        String city = "Mevasseret";
        HashMap<String, String> item_list = new HashMap<>();
        item_list.put("tuna", "fill");
        controller = new DisplaySuperController(this, item_list);
        controller.fillSupers(city);
    }

    public void promptError(String errors){
        Toast.makeText(this, errors, Toast.LENGTH_LONG).show();
    }

    // fill func



    // showing the list to the user
    public void showSupers(ArrayList<SuperDisplay> supers){
        ListAdapter listAdapter = new ListAdapter(this, supers);
        list_view.setAdapter(listAdapter);
        list_view.setClickable(true);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainPageDisplay.this, SuperDetails.class);
                intent.putExtra("name", supers.get(i).getSuper_name());
                intent.putExtra("missing", supers.get(i).getMissing_items());
                intent.putExtra("subs", supers.get(i).getSubstitute_item());
                intent.putExtra("total_price", supers.get(i).getTotal_price());
                startActivity(intent);
            }
        });
    }
}