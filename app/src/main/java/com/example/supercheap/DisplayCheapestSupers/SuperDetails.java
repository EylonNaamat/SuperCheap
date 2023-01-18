package com.example.supercheap.DisplayCheapestSupers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.example.supercheap.DisplayComment.DisplayCommentView;
import com.example.supercheap.R;

public class SuperDetails extends AppCompatActivity {
    private String name;
    private String missing;
    private String subs;
    private String total_price;
    private String rating;
    private String num_comments;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_details);

        Intent intent = this.getIntent();
        if(intent != null){
            this.name = intent.getStringExtra("name");
            this.missing = intent.getStringExtra("missing");
            this.subs = intent.getStringExtra("subs");
            this.total_price = intent.getStringExtra("total_price");
            this.rating = intent.getStringExtra("rating");
            this.num_comments = intent.getStringExtra("num_comments");
            this.city = intent.getStringExtra("city");

            ((TextView)findViewById(R.id.super_name_dis)).setText("Super Name: " + name);
            ((TextView)findViewById(R.id.missing_dis)).setText("Number of missing items is: " + missing);
            ((TextView)findViewById(R.id.subs_dis)).setText("Number of substitute items is: " + subs);
            ((TextView)findViewById(R.id.total_price_dis)).setText("Total price : " + total_price + " ₪");
            ((TextView)findViewById(R.id.rating_dis)).setText("Rating of the super: " + rating);
            ((TextView)findViewById(R.id.numComments_dis)).setText("Num. of comments for this super: " + num_comments);
            ((TextView)findViewById(R.id.city_dis)).setText("City: " + city);
        }
    }

    public void onClickComment(View view){
        Intent i = new Intent(this, DisplayCommentView.class);
        Bundle bundle = new Bundle();
        bundle.putString("super_name", this.name);
        bundle.putString("super_city", this.city);
        i.putExtras(bundle);
        startActivity(i);
    }
}