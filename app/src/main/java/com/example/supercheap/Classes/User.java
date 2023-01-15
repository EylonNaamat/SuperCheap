package com.example.supercheap.Classes;


import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class User implements Parcelable {
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;
    private String city;
    private String birth_date;
    private String gender;
    private boolean is_manager;
    private String super_id;

    public User(){

    }
    public User(JSONObject obj) throws JSONException {
        this.first_name = obj.getString("first_name");
        this.last_name = obj.getString("last_name");
        this.email = obj.getString("email");
        this.username = obj.getString("username");
        this.password = obj.getString("password");
        this.city = obj.getString("city");
        this.birth_date = obj.getString("birth_date");
        this.gender = obj.getString("gender");
        this.is_manager = obj.getBoolean("is_manager");
        this.super_id = obj.getString("super_id");
    }

    public User(User user){
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.city = user.getCity();
        this.birth_date = user.getBirth_date();
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
        this.birth_date = birth_data;
        this.gender = gender;
        this.is_manager = is_manager;
        this.super_id = super_id;
    }

    protected User(Parcel in) {
        first_name = in.readString();
        last_name = in.readString();
        email = in.readString();
        username = in.readString();
        password = in.readString();
        city = in.readString();
        birth_date = in.readString();
        gender = in.readString();
        is_manager = in.readByte() != 0;
        super_id = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(email);
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(city);
        parcel.writeString(birth_date);
        parcel.writeString(gender);
        parcel.writeByte((byte) (is_manager ? 1 : 0));
        parcel.writeString(super_id);
    }
}