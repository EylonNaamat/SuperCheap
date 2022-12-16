package com.example.supercheap.Classes;

import java.util.UUID;

public class Comment {
    private String id_comment;
    private String super_id;
    private String user_username;
    private int Grade;
    private String review;

    public Comment() {
    }

    public Comment(String super_id, String user_username, int grade, String my_review) {
        this.super_id = super_id;
        this.user_username = user_username;
        Grade = grade;
        this.review =my_review;
        this.id_comment = UUID.randomUUID().toString();

    }

    public String getSuper_id() {
        return super_id;
    }

    public void setSuper_id(String super_id) {
        this.super_id = super_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public String getId_comment() {
        return id_comment;
    }

    public void setId_comment(String id_comment) {
        this.id_comment = id_comment;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
