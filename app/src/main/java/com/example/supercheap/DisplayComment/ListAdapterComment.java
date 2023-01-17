package com.example.supercheap.DisplayComment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.supercheap.DisplayCheapestSupers.SuperDisplay;
import com.example.supercheap.R;

import java.util.ArrayList;

public class ListAdapterComment extends ArrayAdapter<CommentDisplay> {
    public ListAdapterComment(Context context, ArrayList<CommentDisplay> commentDisplayList){
        super(context, R.layout.list_comments, commentDisplayList);
        Log.d("test_comment", commentDisplayList.toString());
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("test_comment", "enter showe comments get view");
        CommentDisplay comment_display = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from((getContext())).inflate(R.layout.list_comments,parent, false);
        }

        TextView username = convertView.findViewById(R.id.userName);
        TextView grade = convertView.findViewById(R.id.grade);
        TextView review = convertView.findViewById(R.id.review);

        username.setText(comment_display.getUsername());
        username.setTextColor(Color.parseColor("#FFFFFF"));
        grade.setText(("Grade: " + comment_display.getGrade()));
        grade.setTextColor(Color.parseColor("#FFFFFF"));
        review.setText(("Review: \n" + comment_display.getReview()));
        review.setTextColor(Color.parseColor("#FFFFFF"));

        return convertView;
    }
}
