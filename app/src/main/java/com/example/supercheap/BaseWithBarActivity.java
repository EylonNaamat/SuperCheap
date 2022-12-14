package com.example.supercheap;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.supercheap.databinding.ActivityCreateCartBinding;
import com.example.supercheap.databinding.ActivityHeadButtomTemplateBinding;

public class BaseWithBarActivity extends DrawerBaseActivity {

    ScrollView mRelativeLayout;
    FrameLayout frame_container;
    RelativeLayout header_txt,footer_txt;
    ActivityHeadButtomTemplateBinding activityHeadButtomTemplateBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activityHeadButtomTemplateBinding= ActivityHeadButtomTemplateBinding.inflate(getLayoutInflater());
        setContentView(activityHeadButtomTemplateBinding.getRoot());


    }

    @Override
    public void setContentView(int layoutResID)

    {
        mRelativeLayout = (ScrollView) getLayoutInflater().inflate(R.layout.activity_head_buttom_template, null);
        frame_container = (FrameLayout) mRelativeLayout.findViewById(R.id.frame_container);
        // set the drawer dialog_view as main content view of Activity.
        setContentView(mRelativeLayout);
        // add dialog_view of BaseActivities inside framelayout.i.e. frame_container
        getLayoutInflater().inflate(layoutResID, frame_container, true);

        header_txt = (RelativeLayout) findViewById(R.id.header_RL);
        footer_txt = (RelativeLayout) findViewById(R.id.footer_RL);

    }
}