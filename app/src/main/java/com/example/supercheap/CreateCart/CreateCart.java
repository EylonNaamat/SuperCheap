package com.example.supercheap.CreateCart;



import android.content.Intent;
import android.os.Bundle;
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

public class CreateCart extends BaseWithBarActivity {
    CreatCartController CController= new CreatCartController(this);
    Button insert;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cart);
        ListView listView = (ListView) findViewById(R.id.my_list);
        insert=findViewById(R.id.insert);
        adapter = new MyListAdapter(getApplicationContext(),R.layout.list_item,arrayList);
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
         CController.inDict(my_item_name.getText().toString());

    }
    public void ShowCheaper(View v){
        EditText my_city_name=findViewById(R.id.Cart_City);

        CController.FindCheaper(arrayList,my_city_name.getText().toString(),user);
    }

    public void find(String city) {

        HashMap<String,String> myHash=CController.convertArrayListToHash(arrayList);
        Intent intent = new Intent(this, MainPageDisplay.class);
        intent.putExtra("user1",user);
        intent.putExtra("item_list",myHash);
        intent.putExtra("city",city);
        startActivity(intent);
        overridePendingTransition(0,0);
    }


    public void add(String item) {
        EditText my_company_name=findViewById(R.id.company_item_name);
        if (item.length()==0||my_company_name.getText().toString().length()==0){
            throwNote("Bad input");
        }else {
            arrayList.add( item+ "," + my_company_name.getText().toString());
            adapter.notifyDataSetChanged();
            EditText my_item_name=findViewById(R.id.Cart_Item);
            my_item_name.setText("");
            my_company_name.setText("");
        }
    }


}