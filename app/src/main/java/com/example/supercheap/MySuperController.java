package com.example.supercheap;

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
}
