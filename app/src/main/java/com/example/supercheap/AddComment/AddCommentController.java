package com.example.supercheap.AddComment;

import com.example.supercheap.Classes.User;

public class AddCommentController {
    AddCommentActivity my_view;
    AddCommentModel my_model;

    public AddCommentController(AddCommentActivity my_view) {
        this.my_view = my_view;
        this.my_model = new AddCommentModel(this);
    }

    public void sendComment( String super_name,String grade,String review, User user)
    {
        try{
            int new_grade = Integer. parseInt(grade);
            if(new_grade<0 || new_grade>5)
            {
                my_view.throwNote("grade should be number between 0-5");
            }
            else
            {
                my_model.insertComment(super_name,new_grade,review,user);
            }
        }
        catch (Exception e)
        {
            my_view.throwNote("grade should be number between 0-5");
        }
    }
    public void throwNote(String content)
    {
        this.my_view.throwNote(content);
    }
    public void commentsend()
    {
        this.my_view.sended_rest();
    }
}
