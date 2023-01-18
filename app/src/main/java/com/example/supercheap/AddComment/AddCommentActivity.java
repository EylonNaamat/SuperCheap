package com.example.supercheap.AddComment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.R;

public class AddCommentActivity extends BaseWithBarActivity {
    private AddCommentController my_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);

        my_control = new AddCommentController(this);

    }

    public void sendComment(View v)
    {
//        get the details and send it to controller
        String super_name = ((EditText) findViewById(R.id.commen_super_name_input)).getText().toString();
        String super_city = ((EditText) findViewById(R.id.commen_super_city_input)).getText().toString();

        super_name = super_name.toLowerCase();
        super_city = super_city.toLowerCase();

        String grade = ((EditText) findViewById(R.id.comment_super_grade_input)).getText().toString();
        String review = ((EditText) findViewById(R.id.comment_review_input)).getText().toString();

        my_control.sendComment(super_name,super_city,grade,review);
    }
    //reset the text in the page and report that the comment was send
    public void sended_rest() {
        ((EditText) (findViewById(R.id.commen_super_name_input))).setText(null);
        ((EditText) (findViewById(R.id.commen_super_city_input))).setText(null);
        ((EditText) (findViewById(R.id.comment_super_grade_input))).setText(null);
        ((EditText) (findViewById(R.id.comment_review_input))).setText(null);

        throwNote("comment send");
    }

    public void throwNote(String content)
    {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();
                Toast.makeText(context, content, Toast.LENGTH_LONG).show();
            }
        });
    }

}