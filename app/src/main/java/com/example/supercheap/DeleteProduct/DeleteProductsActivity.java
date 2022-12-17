package com.example.supercheap.DeleteProduct;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.Manager.ControllerManager;
import com.example.supercheap.R;

public class DeleteProductsActivity extends BaseWithBarActivity {
    DeleteController DController= new DeleteController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_products);
//        user= (User) getIntent().getSerializableExtra("user");

    }

    public void throwNote(String content){
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }
    public void Delete(View buttonEnterPrice ) {
        EditText itemName = findViewById(R.id.Item_Name_Delete);
        EditText company = findViewById(R.id.Company_Name_Delete);

        DController.TryDelete(String.valueOf(itemName.getText()), company.getText().toString(), user);
    }
    public void Done(String s){throwNote(s);}

}