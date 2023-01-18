package com.example.supercheap.HomePage;

import com.example.supercheap.AddComment.AddCommentActivity;
import com.example.supercheap.AddComment.AddCommentController;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONObject;

public class HomePageModel {

    private HomePageController my_control;
    private HomePageActivity my_view;

    public HomePageModel(HomePageController my_control, HomePageActivity my_view) {
        this.my_control = my_control;
        this.my_view = my_view;
    }
    //make the message and send it to the view for notificate
    public void createMassage(JSONObject obj)
    {
        try {
            //check nubmber of new comment if none send that there is no new comment if more the 0 send the comments
            int numOfNew = obj.getInt("numberOfNew");
            if(numOfNew == 0)
            {
                String title = "you have "+numOfNew+" new comments";
                my_view.send_notifiction(title,"have good day", 0);
            }
            else
            {
                String title = "you have "+numOfNew+" new comments";
                String text = "for see the comment fo to comment page and see the new coment";

                my_view.send_notifiction(title,text, 0);

                JSONArray keys = obj.names();
                for(int i = 0 ; i<keys.length(); i++)
                {
                    String key = keys.getString(i);
                    if(!key.equals("numberOfNew"))
                    {
                        title = "comment number:"+i;
                        text = obj.getString(key);
                        my_view.send_notifiction(title,text,i+1);
                    }
                }
            }
        }
        catch (Exception e)
        {
            my_view.throwNote("error in getting ans jsom read Home Page model");
        }

    }

}
