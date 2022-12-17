package com.example.supercheap;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.supercheap.Classes.User;
import com.example.supercheap.DisplayCheapestSupers.MainPageDisplay;
import com.example.supercheap.Manager.ControllerManager;
import com.example.supercheap.databinding.ActivityCreateCartBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateCart extends BaseWithBarActivity {
    CreatCartController CController= new CreatCartController(this);
    HashMap<String,String> cart_item=new HashMap<>();


    Button button;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cart);
        allocateActivityTitle("Create cart");
        button=findViewById(R.id.insert);
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
    public void throwNote(String content){
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }
    public void AddToList(View v){
        EditText my_item_name=findViewById(R.id.Cart_Item);
        EditText my_company_name=findViewById(R.id.company_item_name);
        arrayList.add("name="+my_item_name.getText().toString()+" ,company="+my_company_name.getText().toString());
        adapter.notifyDataSetChanged();
        cart_item.put(my_item_name.getText().toString(),my_company_name.getText().toString());
    }
    public void ShowCheaper(View v){
        EditText my_city_name=findViewById(R.id.Cart_City);

        CController.FindCheaper(cart_item,my_city_name.getText().toString(),user);
    }


    public void find(HashMap<String, String> cart_item, String city, User user) {
        Intent intent = new Intent(this, MainPageDisplay.class);
        intent.putExtra("user1",user);
        intent.putExtra("item_list",cart_item);
        intent.putExtra("city",city);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}