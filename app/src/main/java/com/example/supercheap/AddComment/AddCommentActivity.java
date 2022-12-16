package com.example.supercheap.AddComment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.BaseWithBarActivity;
import com.example.supercheap.R;

public class AddCommentActivity extends BaseWithBarActivity {
    AddCommentController my_control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);

        my_control = new AddCommentController(this);

    }

    public void sendComment(View v)
    {
        String super_name = ((EditText) findViewById(R.id.commen_super_name_input)).getText().toString();
        String grade = ((EditText) findViewById(R.id.comment_super_grade_input)).getText().toString();
        String review = ((EditText) findViewById(R.id.comment_review_input)).getText().toString();
        my_control.sendComment(super_name,grade,review,user);
    }

    public void sended_rest() {
        ((EditText) (findViewById(R.id.commen_super_name_input))).setText(null);
        ((EditText) (findViewById(R.id.comment_super_grade_input))).setText(null);
        ((EditText) (findViewById(R.id.comment_review_input))).setText(null);
        throwNote("comment send");
    }
    public void throwNote(String content)
    {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

}