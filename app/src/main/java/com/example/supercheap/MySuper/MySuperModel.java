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
    private DatabaseReference my_bd;

    public MySuperModel(MySuperController temp_con)
    {
        this.my_control = temp_con;
        this.my_bd = FirebaseDatabase.getInstance().getReference();
    }
    public void getSuperDetails(String Super_Id)
    {
        this.my_bd.child("Supers").child(Super_Id).child("super_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    my_control.setSuperName(task.getResult().getValue().toString());
                }
                else {
                    my_control.throwNote("fail to get super name");
                }
            }
        });
        this.my_bd.child("Supers").child(Super_Id).child("super_city").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    my_control.setSuperCity(task.getResult().getValue().toString());
                }
                else {
                    my_control.throwNote("fail to get super city");
                }
            }
        });
    }

    public void setNewSuper(String super_name, String super_city, User user)
    {
        this.my_bd.child("Supers").child(user.getSuper_id()).child("super_city").setValue(super_city);
        this.my_bd.child("Supers").child(user.getSuper_id()).child("super_name").setValue(super_name);
    }
}
