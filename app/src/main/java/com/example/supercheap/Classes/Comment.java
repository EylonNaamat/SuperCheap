package com.example.supercheap.Classes;

import java.util.UUID;

public class Comment {
    private String id_comment;
    private String super_name;
    private String super_city;
    private String user_username;
    private int grade;
    private String review;

    public Comment() {
    }

    public Comment(String super_name, String super_city, String user_username, int grade, String review) {
        this.id_comment = this.id_comment = UUID.randomUUID().toString();
        this.super_name = super_name;
        this.super_city = super_city;
        this.user_username = user_username;
        this.grade = grade;
        this.review = review;
    }

    public String getId_comment() {
        return id_comment;
    }

    public void setId_comment(String id_comment) {
        this.id_comment = id_comment;
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

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
