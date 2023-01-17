package com.example.supercheap.DisplayCheapestSupers;

import android.util.Pair;

import java.util.HashMap;

public class SuperDisplay {
    private String super_name;
    private String missing_items;
    private String substitute_item;
    private String total_price;
    private String grade;
    private String num_comments;
    private String city;
    private String super_id;
    private HashMap<String, Integer> product;
    private String[] missing_products;
    private HashMap<String, Pair<String, Integer>> subs_products;


    public SuperDisplay(String super_name, String missing_items, String substitute_item, String total_price, String grade, String num_comments, String city) {
        this.super_name = super_name;
        this.missing_items = missing_items;
        this.substitute_item = substitute_item;
        this.total_price = total_price;
        this.grade = grade;
        this.num_comments = num_comments;
        this.city = city;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getNum_comments() {
        return num_comments;
    }

    public void setNum_comments(String num_comments) {
        this.num_comments = num_comments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "SuperDisplay{" +
                "super_name='" + super_name + '\'' +
                ", missing_items='" + missing_items + '\'' +
                ", substitute_item='" + substitute_item + '\'' +
                ", total_price='" + total_price + '\'' +
                ", grade='" + grade + '\'' +
                ", num_comments='" + num_comments + '\'' +
                '}';
    }
}
