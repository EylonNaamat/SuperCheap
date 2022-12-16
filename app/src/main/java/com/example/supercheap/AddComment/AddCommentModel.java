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

public class AddCommentModel {

    AddCommentController my_control;
    private DatabaseReference my_bd;

    public AddCommentModel(AddCommentController my_control) {
        this.my_control = my_control;
        this.my_bd = FirebaseDatabase.getInstance().getReference();
    }

    public void insertComment(String super_name,int grade,String review, User user)
    {

        DatabaseReference curr_databasereference = this.my_bd.child("Supers");
        Query query = curr_databasereference.orderByChild("super_name").equalTo(super_name);
        Log.d("querytest", "start");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("querytest", "2");
                if (dataSnapshot.exists()) {
                    Log.d("querytest", "3");
                    Super my_super = new Super();
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot my_object : dataSnapshot.getChildren()) {
                        my_super = my_object.getValue(Super.class);
                        Log.d("querytest", my_super.getSuper_ID());
                    }
                    if(my_super.getSuper_ID().equals(""))
                    {
                        my_control.throwNote("super not exist");
                    }
                    else
                    {
//                        my_super.changeGrade(grade);
                        Comment new_comment = new Comment(my_super.getSuper_ID(),user.getUsername(),grade,review);
                        my_bd.child("comments").child(new_comment.getId_comment()).setValue(new_comment);
                        my_control.commentsend();
                    }

                }
                else
                {
                    my_control.throwNote("super not exist");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
