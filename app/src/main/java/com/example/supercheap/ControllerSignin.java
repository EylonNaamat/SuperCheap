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

    public void succesLogin()
    {
        my_view.sighInSucces();
    }

    public void failLogin()
    {
        my_view.throwNote("bad username or password");
    }

    public void databaseErore()
    {
        my_view.throwNote("firebase feil");
    }

}
