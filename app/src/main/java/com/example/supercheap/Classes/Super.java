package com.example.supercheap.Classes;

import java.util.HashMap;

public class Super {
    private String super_ID;
    private String super_name;
    private String super_city;
    private HashMap<String,HashMap<String,Double>> products;
    private HashMap<String ,Comment> comments; // the string is the comment id
    private int comments_size;
    private double super_rating;

    public Super() {
    }

    public Super(String super_ID, String super_name, String super_city, HashMap<String, HashMap<String, Double>> products, HashMap<String, Comment> comments, int comments_size, double super_rating) {
        this.super_ID = super_ID;
        this.super_name = super_name;
        this.super_city = super_city;
        this.products = products;
        this.comments = comments;
        this.comments_size = comments_size;
        this.super_rating = super_rating;
    }


    public String getSuper_ID() {
        return super_ID;
    }

    public void setSuper_ID(String super_ID) {
        this.super_ID = super_ID;
    }

    public String getSuper_name() {
        return super_name;
    }

    public void setSuper_name(String super_name) {
        this.super_name = super_name;
    }

    public String getSuper_city() {
        return super_city;
    }

    public void setSuper_city(String super_city) {
        this.super_city = super_city;
    }

    public HashMap<String, HashMap<String, Double>> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, HashMap<String, Double>> products) {
        this.products = products;
    }

    public HashMap<String, Comment> getComments() {
        return comments;
    }

    public void setComments(HashMap<String, Comment> comments) {
        this.comments = comments;
    }

    public int getComments_size() {
        return comments_size;
    }

    public void setComments_size(int comments_size) {
        this.comments_size = comments_size;
    }

    public double getSuper_rating() {
        return super_rating;
    }

    public void setSuper_rating(double super_rating) {
        this.super_rating = super_rating;
    }
}
