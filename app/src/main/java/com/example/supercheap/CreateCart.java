package com.example.supercheap;



import android.os.Bundle;

import com.example.supercheap.databinding.ActivityCreateCartBinding;

public class CreateCart extends BaseWithBarActivity {
    ActivityCreateCartBinding activityCreateCartBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        activityCreateCartBinding=ActivityCreateCartBinding.inflate(getLayoutInflater());
//        setContentView(activityCreateCartBinding.getRoot());
        allocateActivityTitle("Create cart");



    }



}