package com.example.supercheap.AddComment;

import android.util.Log;

import com.example.supercheap.AddComment.AddCommentController;
import com.example.supercheap.Classes.Comment;
import com.example.supercheap.Classes.Super;
import com.example.supercheap.Classes.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class AddCommentModel {

    private AddCommentController my_control;
    private AddCommentActivity my_view;
    private DatabaseReference my_bd;

    public AddCommentModel(AddCommentController my_control, AddCommentActivity my_view) {
        this.my_control = my_control;
        this.my_view = my_view;
        this.my_bd = FirebaseDatabase.getInstance().getReference();
    }
    //check if the details are goo if it is it send it to the controler for send it to the server else ask the view to throw not
    public void checkgrade(String super_name,String super_city,String grade,String review)
    {

        try{
            int new_grade = Integer. parseInt(grade);
            if(super_name == null)
            {
                my_view.throwNote("you have to insert super name");
            }
            else if(super_city == null)
            {
                my_view.throwNote("you have to insert super city");
            }
            else if(new_grade<0 || new_grade>5)
            {
                my_view.throwNote("grade should be number between 0-5");
            }
            else
            {
                super_name = super_name.toLowerCase();
                super_city = super_city.toLowerCase();
                Comment new_comment = new Comment(super_name,super_city,my_view.user.getUsername(), new_grade,review);
                my_control.insertComment(new_comment);
            }
        }
        catch (Exception e)
        {
            my_view.throwNote("grade should be number between 0-5");
        }
    }
}
