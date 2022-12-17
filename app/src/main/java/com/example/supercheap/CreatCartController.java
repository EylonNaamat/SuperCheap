package com.example.supercheap;

import com.example.supercheap.Classes.User;

import java.util.HashMap;

public class CreatCartController {
    private CreateCart createCart;
    private CreateCartModel creatCartModel;


    public CreatCartController(CreateCart createCart) {
        this.creatCartModel=new CreateCartModel(this);
        this.createCart=createCart;
    }

    public void FindCheaper(HashMap<String, String> cart_item, String city, User user) {
        if (city.length()==0||cart_item.size()==0){
            createCart.throwNote("Bad input");
        }
        createCart.find(cart_item,city,user);
    }
}
