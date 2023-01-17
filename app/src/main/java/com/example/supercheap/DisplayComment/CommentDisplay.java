package com.example.supercheap.DisplayComment;

public class CommentDisplay {
    private String grade;
    private String review;
    private String username;

    public CommentDisplay(String grade, String review, String username) {
        this.grade = grade;
        this.review = review;
        this.username = username;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CommentDisplay{" +
                "grade='" + grade + '\'' +
                ", review='" + review + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
