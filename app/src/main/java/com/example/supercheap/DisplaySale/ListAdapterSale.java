package com.example.supercheap.DisplaySale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.supercheap.DisplayComment.CommentDisplay;
import com.example.supercheap.R;

import java.util.ArrayList;

public class ListAdapterSale extends ArrayAdapter<SalesDisplay> {
    public ListAdapterSale(Context context, ArrayList<SalesDisplay> saleDisplayList){
        super(context, R.layout.list_sales, saleDisplayList);
        Log.d("test_comment", saleDisplayList.toString());
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("test_comment", "enter showe comments get view");
        SalesDisplay sale_display = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from((getContext())).inflate(R.layout.list_sales,parent, false);
        }

        TextView sale_name = convertView.findViewById(R.id.list_sales_salename);
        TextView item = convertView.findViewById(R.id.list_sales_product_name);
        TextView company = convertView.findViewById(R.id.list_sales_product_company);
        TextView quantity = convertView.findViewById(R.id.list_sales_product_quantity_value);
        TextView price = convertView.findViewById(R.id.list_sales_product_price_value);


        sale_name.setText(sale_display.getSale_name());
        sale_name.setTextColor(Color.parseColor("#FFFFFF"));
        item.setText(("Grade: " + sale_display.getItem()));
        item.setTextColor(Color.parseColor("#FFFFFF"));
        company.setText(("Company: " + sale_display.getCompany()));
        company.setTextColor(Color.parseColor("#FFFFFF"));
        quantity.setText((sale_display.getQuantity()));
        quantity.setTextColor(Color.parseColor("#FFFFFF"));
        price.setText((sale_display.getPrice() + " ₪"));
        price.setTextColor(Color.parseColor("#FF0000"));

        return convertView;
    }
}
