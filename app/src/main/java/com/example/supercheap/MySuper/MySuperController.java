package com.example.supercheap.MySuper;

public class MySuperController {
    MySuperActivity my_view;
    MySuperModel my_modle;

    public MySuperController(MySuperActivity temp_view)
    {
        this.my_view = temp_view;
        this.my_modle = new MySuperModel(this);

    }

    public void throwNote(String content)
    {
        my_view.throwNote(content);
    }

    public void checkSuperDetails(){
        my_modle.getSuperDetails(my_view.user.getSuper_id());
    }
    public void setSuperName(String super_name) {
        my_view.setSuperName(super_name);
    }
    public void setSuperCity(String super_city) {
        my_view.setSuperCity((super_city));
    }
    public void updateUser(String super_name, String super_city)
    {
        my_modle.setNewSuper(super_name,super_city,this.my_view.user);
    }
}
