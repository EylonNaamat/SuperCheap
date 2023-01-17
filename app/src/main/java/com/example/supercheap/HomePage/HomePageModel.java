package com.example.supercheap.HomePage;

import com.example.supercheap.AddComment.AddCommentActivity;
import com.example.supercheap.AddComment.AddCommentController;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomePageModel {

    private HomePageController my_control;
    private HomePageActivity my_view;

    public HomePageModel(HomePageController my_control, HomePageActivity my_view) {
        this.my_control = my_control;
        this.my_view = my_view;
    }

}
