package com.example.supercheap.DisplayComment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.supercheap.R;

public class CommentDetails extends AppCompatActivity {
    private String username;
    private String grade;
    private String review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_details);


        Intent intent = this.getIntent();
        if(intent != null){
            this.username = intent.getStringExtra("username");
            this.grade = intent.getStringExtra("grade");
            this.review = intent.getStringExtra("review");

            ((TextView)findViewById(R.id.username_dis)).setText(this.username);
            ((TextView)findViewById(R.id.grade_dis)).setText("Grade: " + this.grade);
            ((TextView)findViewById(R.id.review_dis)).setText("Review: " + this.review);
        }
    }

}