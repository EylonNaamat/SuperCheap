package com.example.supercheap;



public class User {
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;
    private String city;
    private String birth_data;
    private String gender;
    private boolean is_manager;
    private String super_id;

    public User(){

    }
    public User(User user){
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.city = user.getCity();
        this.birth_data = user.getBirth_data();
        this.gender = user.getGender();
        this.is_manager = user.getIs_manager();
        this.super_id = user.getSuper_id();
    }

    public User(String first_name, String last_name, String email, String username, String password, String city, String birth_data, String gender, boolean is_manager, String super_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.city = city;
        this.birth_data = birth_data;
        this.gender = gender;
        this.is_manager = is_manager;
        this.super_id = super_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirth_data() {
        return birth_data;
    }

    public void setBirth_data(String birth_data) {
        this.birth_data = birth_data;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getIs_manager() {
        return is_manager;
    }

    public void setIs_manager(boolean is_manager) {
        this.is_manager = is_manager;
    }

    public String getSuper_id() {
        return super_id;
    }

    public void setSuper_id(String super_id) {
        this.super_id = super_id;
    }

}