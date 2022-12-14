package com.example.supercheap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.supercheap.databinding.ActivityDashboardBinding;

public class DashboardActivity extends BaseWithBarActivity {

        ActivityDashboardBinding activityDashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding =ActivityDashboardBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Dashboard");
        setContentView(activityDashboardBinding.getRoot());
    }
}