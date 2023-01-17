package com.example.supercheap.DisplayCheapestSupers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.supercheap.Classes.Super;
import com.example.supercheap.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<SuperDisplay> {
    public ListAdapter(Context context, ArrayList<SuperDisplay> superDisplayList){
        super(context, R.layout.list_supers, superDisplayList);
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SuperDisplay super_display = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from((getContext())).inflate(R.layout.list_supers,parent, false);
        }

        TextView super_name = convertView.findViewById(R.id.superName);
        TextView missing_item = convertView.findViewById(R.id.missingItems);
        TextView substitute_item = convertView.findViewById(R.id.substituteItems);
        TextView total_price = convertView.findViewById(R.id.totalPrice);
        TextView rating = convertView.findViewById(R.id.rating);
        TextView num_comments = convertView.findViewById(R.id.numComments);

        super_name.setText(super_display.getSuper_name());
        super_name.setTextColor(Color.parseColor("#FFFFFF"));
        missing_item.setText(("Missing items: " + super_display.getMissing_items()));
        missing_item.setTextColor(Color.parseColor("#FFFFFF"));
        substitute_item.setText(("Substitute items: " + super_display.getSubstitute_item()));
        substitute_item.setTextColor(Color.parseColor("#FFFFFF"));
        total_price.setText(super_display.getTotal_price() + " ₪");
        total_price.setTextColor(Color.parseColor("#FFFFFF"));
        rating.setText(("Rating: " + super_display.getGrade()));
        rating.setTextColor(Color.parseColor("#FFFFFF"));
        num_comments.setText(("No. com.: " + super_display.getNum_comments()));
        num_comments.setTextColor(Color.parseColor("#FFFFFF"));


        return convertView;
    }
}
