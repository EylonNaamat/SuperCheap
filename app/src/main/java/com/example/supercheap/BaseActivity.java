package com.example.supercheap;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

public class BaseActivity extends FragmentActivity {

    ScrollView mRelativeLayout;
    FrameLayout frame_container;
    RelativeLayout header_txt,footer_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void setContentView(int layoutResID)

    {
        mRelativeLayout = (ScrollView) getLayoutInflater().inflate(R.layout.head_buttom_template, null);
        frame_container = (FrameLayout) mRelativeLayout.findViewById(R.id.frame_container);
        // set the drawer dialog_view as main content view of Activity.
        setContentView(mRelativeLayout);
        // add dialog_view of BaseActivities inside framelayout.i.e. frame_container
        getLayoutInflater().inflate(layoutResID, frame_container, true);

        header_txt = (RelativeLayout) findViewById(R.id.header_RL);
        footer_txt = (RelativeLayout) findViewById(R.id.footer_RL);

    }
}