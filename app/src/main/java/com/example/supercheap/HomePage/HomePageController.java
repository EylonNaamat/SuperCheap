package com.example.supercheap.HomePage;

import com.example.supercheap.AddComment.AddCommentActivity;
import com.example.supercheap.AddComment.AddCommentModel;

import okhttp3.OkHttpClient;

public class HomePageController {
    private HomePageActivity my_view;
    private HomePageModel my_model;
    private OkHttpClient client;

    public HomePageController(HomePageActivity my_view) {
        this.my_view = my_view;
        this.client = new OkHttpClient();
        this.my_model = new HomePageModel(this,my_view);
    }
}
