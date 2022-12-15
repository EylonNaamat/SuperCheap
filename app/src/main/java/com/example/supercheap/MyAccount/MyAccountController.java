package com.example.supercheap.MyAccount;

public class MyAccountController {
    MyAccountActivity my_view;
    MyAccountModel my_modle;

    public MyAccountController(MyAccountActivity temp_view)
    {
        this.my_view = temp_view;
        this.my_modle = new MyAccountModel(this);

    }

    public void throwNote(String content)
    {
        my_view.throwNote(content);
    }

    public void updateUser(String first_name,String last_name,String email, String password,String city,String birth_date,boolean male,boolean female) {
        my_view.user.setFirst_name(first_name);
        my_view.user.setLast_name(last_name);
        my_view.user.setEmail(email);
        my_view.user.setPassword(password);
        my_view.user.setCity(city);
        my_view.user.setBirth_date(birth_date);
        if (male) {
            my_view.user.setGender("Male");
        } else {
            my_view.user.setGender("Female");
        }
        my_modle.setupdateuser(this.my_view.user);
    }

}
