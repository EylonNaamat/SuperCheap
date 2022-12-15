package com.example.supercheap;

public class ControllerSignin {
    private SigninActivity my_view;
    private ModelSignin my_model;
    public ControllerSignin(SigninActivity view)
    {
        this.my_model = new ModelSignin(this);
        this.my_view = view;
    }


    public void tryLogin(String username, String password)
    {
        my_model.DoLogIN(username,password);
    }

    public void succesLogin( User temp_user)
    {
        my_view.signInSucces(temp_user);
    }

    public void throwNote(String content)
    {
        my_view.throwNote(content);
    }


}
