package com.example.supercheap.DisplayCheapestSupers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.supercheap.BaseActivity;
import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.R;
import com.example.supercheap.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainPageDisplay extends BaseWithBarActivity {
    ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_display);

        list_view = (ListView) findViewById(R.id.listview);


        String[] name = {"Shufersal", "Rami Levi", "Victory", "Yinot Bitan", "Hatzi Hinam", "Yohananof", "Eylon", "Michael", "Ben"};
        String[] missing = {"4","3","4","5","4","8","1","2","6"};
        String[] subs = {"2","3","11","0","4","7","1","2","6"};
        String[] price = {"190","300","412","504","444","851","50","1","63"};

        ArrayList<SuperDisplay> superArrayList = new ArrayList<>();
        for(int i = 0; i < name.length; ++i){
            SuperDisplay new_super = new SuperDisplay(name[i], missing[i], subs[i], price[i]);
            superArrayList.add(new_super);
        }

        ListAdapter listAdapter = new ListAdapter(this, superArrayList);
        list_view.setAdapter(listAdapter);
        list_view.setClickable(true);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainPageDisplay.this, SuperDetails.class);
                intent.putExtra("name", name[i]);
                intent.putExtra("missing", missing[i]);
                intent.putExtra("subs", subs[i]);
                intent.putExtra("total_price", price[i]);
                startActivity(intent);
            }
        });
    }
}