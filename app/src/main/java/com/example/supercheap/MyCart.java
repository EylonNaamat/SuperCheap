package com.example.supercheap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.supercheap.databinding.ActivityMyCartBinding;

public class MyCart extends BaseWithBarActivity {
    ActivityMyCartBinding activityMyCartBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        activityMyCartBinding=ActivityMyCartBinding.inflate(getLayoutInflater());
//        setContentView(activityMyCartBinding.getRoot());
        allocateActivityTitle("My Cart");
    }


}