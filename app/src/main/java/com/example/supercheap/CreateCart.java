package com.example.supercheap;



import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.supercheap.databinding.ActivityCreateCartBinding;

import java.util.ArrayList;

public class CreateCart extends BaseWithBarActivity {

    EditText editText;
    Button button;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cart);

//        activityCreateCartBinding=ActivityCreateCartBinding.inflate(getLayoutInflater());
//        setContentView(activityCreateCartBinding.getRoot());
        allocateActivityTitle("Create cart");

        editText=findViewById(R.id.veri);
        button=findViewById(R.id.kaydet);
        listView=findViewById(R.id.my_list);

        arrayList=new ArrayList<>();

        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CreateCart.this, ""+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void AddToList(View kaydet){
        String YeniVeri=editText.getText().toString();
        arrayList.add(YeniVeri);
        adapter.notifyDataSetChanged();
        editText.setText("");
    }



}