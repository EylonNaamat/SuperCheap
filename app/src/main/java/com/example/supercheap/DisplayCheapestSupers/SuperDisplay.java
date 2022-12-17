package com.example.supercheap.DisplayCheapestSupers;

import android.util.Pair;

import java.util.HashMap;

public class SuperDisplay {
    private String super_name;
    private String missing_items;
    private String substitute_item;
    private String total_price;
    private int grade;
    private int num_comments;
    private String super_id;
    private HashMap<String, Integer> product;
    private String[] missing_products;
    private HashMap<String, Pair<String, Integer>> subs_products;

    public SuperDisplay(String super_name, String missing_items, String substitute_item, String total_price) {
        this.super_name = super_name;
        this.missing_items = missing_items;
        this.substitute_item = substitute_item;
        this.total_price = total_price;
    }

    public String getSuper_name() {
        return super_name;
    }

    public void setSuper_name(String super_name) {
        this.super_name = super_name;
    }

    public String getMissing_items() {
        return missing_items;
    }

    public void setMissing_items(String missing_items) {
        this.missing_items = missing_items;
    }

    public String getSubstitute_item() {
        return substitute_item;
    }

    public void setSubstitute_item(String substitute_item) {
        this.substitute_item = substitute_item;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }
}
