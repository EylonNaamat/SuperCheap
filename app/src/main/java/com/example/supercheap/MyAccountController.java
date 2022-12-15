package com.example.supercheap;

import android.widget.EditText;
import android.widget.Toast;

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

}
