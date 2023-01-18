package com.example.supercheap.CreateCart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.supercheap.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyListAdapter extends ArrayAdapter<String> {
    private int layout;
    private ArrayList<String> arrayList;
    private ArrayList<String> send_list;

    public MyListAdapter(@NonNull Context context, int resource, @NonNull List<String> objects, @NonNull List<String> send_list) {
        super(context, resource, objects);
        layout = resource;
        arrayList = (ArrayList<String>) objects;
        this.send_list = (ArrayList<String>) send_list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mainViewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.list_item_num);
            viewHolder.textView.setText(arrayList.get(arrayList.size() - 1));
            viewHolder.button = convertView.findViewById(R.id.XButton);
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String t = arrayList.get(position);
                    arrayList.remove(position);
                    send_list.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(viewHolder);
        } else {
            mainViewHolder = (ViewHolder) convertView.getTag();
            mainViewHolder.textView.setText(getItem(position));
        }
        return convertView;
    }

    private class ViewHolder {
        TextView textView;
        Button button;
    }
}


