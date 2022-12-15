package com.example.supercheap.Classes;

import java.util.HashMap;

public class Super {
    String super_ID;
    String super_name;
    String super_city;
    HashMap<String,HashMap<String,Double>> products;

    public Super() {
    }
    public Super(Super my_super){
        this.super_ID = my_super.getSuper_ID();
        this.super_name = my_super.getSuper_name();
        this.super_city = my_super.getSuper_city();
        this.products = new HashMap<>(my_super.getProducts());
    }
    public Super(String super_ID, String super_name, String super_city, HashMap<String, HashMap<String, Double>> products) {
        this.super_ID = super_ID;
        this.super_name = super_name;
        this.super_city = super_city;
        this.products = new HashMap<>(products);
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
}
