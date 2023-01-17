package com.example.supercheap.HomePage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.supercheap.AddComment.AddCommentController;
import com.example.supercheap.BaseActivity;
import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.R;

public class HomePageActivity extends BaseWithBarActivity {
    HomePageController my_control;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ((TextView) (findViewById(R.id.home_page_username))).setText(this.user.getFirst_name()+" "+this.user.getLast_name());
        my_control = new HomePageController(this);
    }

}