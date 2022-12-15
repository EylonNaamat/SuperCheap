package com.example.supercheap;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyAccountModel {
    MyAccountController my_control;
    private DatabaseReference my_bd;

    public MyAccountModel(MyAccountController temp_con)
    {
        this.my_control = temp_con;
        this.my_bd = FirebaseDatabase.getInstance().getReference();
    }

}
