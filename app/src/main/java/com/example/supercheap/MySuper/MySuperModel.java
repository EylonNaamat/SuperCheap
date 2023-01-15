package com.example.supercheap.MySuper;

import androidx.annotation.NonNull;

import com.example.supercheap.Classes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MySuperModel {
    MySuperController my_control;
    MySuperActivity my_view;
    private DatabaseReference my_bd;

    public MySuperModel(MySuperController temp_con,MySuperActivity temp_view)
    {
        this.my_view = temp_view;
        this.my_control = temp_con;
        this.my_bd = FirebaseDatabase.getInstance().getReference();
    }

    public void checkSuperDetails(String super_name, String super_city, User user)
    {
       if(super_name == null)
       {
          this.my_view.throwNote("bad super name");
       }
       if(super_city == null)
       {
           this.my_view.throwNote("bad super id");
       }
       this.my_control.updateSuper(super_name,super_city);
    }
}
