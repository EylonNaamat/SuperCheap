package com.example.supercheap.DisplayComment;

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

import com.example.supercheap.Classes.User;

import com.example.supercheap.R;

import java.util.ArrayList;

public class DisplayCommentView extends AppCompatActivity {
    private String super_name;
    private String super_city;
    private DisplayCommentController controller;
    ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("test_comment", "3");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_comment_view);

        list_view = (ListView) findViewById(R.id.commentslistview);

        Bundle bundle = getIntent().getExtras();
        this.super_name = bundle.getString("super_name");
        this.super_city = bundle.getString("super_city");

        this.controller= new DisplayCommentController(this);
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

    public void showComments(ArrayList<CommentDisplay> comments){
        Log.d("test_comment", "enter showe comments");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Log.d("test_comment", "enter showe comments 2");

                ListAdapterComment listAdapter = new ListAdapterComment(context, comments);
                list_view.setAdapter(listAdapter);
                list_view.setClickable(true);
                list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Log.d("test_comment", "enter click");
                        Log.d("test_comment", ("i is " + i));

                        Intent intent = new Intent(DisplayCommentView.this, CommentDetails.class);

                        intent.putExtra("username", comments.get(i).getUsername());
                        Log.d("test_comment", comments.get(i).getUsername());
                        intent.putExtra("grade", comments.get(i).getGrade());
                        Log.d("test_comment", comments.get(i).getGrade());
                        intent.putExtra("review", comments.get(i).getReview());
                        Log.d("test_comment", comments.get(i).getReview());
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