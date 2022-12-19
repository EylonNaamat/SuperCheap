package com.example.supercheap.CreateCart;

import com.example.supercheap.Classes.User;

import java.util.ArrayList;
import java.util.HashMap;

public class CreatCartController {
    private CreateCart createCart;
    private CreateCartModel creatCartModel;


    public CreatCartController(CreateCart createCart) {
        this.creatCartModel=new CreateCartModel(this);
        this.createCart=createCart;
    }

    public void FindCheaper(ArrayList<String> arrayList, String city, User user) {
        if (city.length()==0||arrayList.size()==0){
            createCart.throwNote("Bad input");
        }else {
            creatCartModel.DoInCity(city);
        }
    }

    public void inDict(String item) {
        creatCartModel.DoInDict(item);
    }

    public void addTolist(String item) {
        createCart.add(item);
    }

    public void confindcheaper(String mysuper) {
        createCart.find(mysuper);
    }
    public void toast(String s) {
        createCart.throwNote(s);
    }

    public HashMap<String, String> convertArrayListToHash(ArrayList<String> arrayList) {
        HashMap<String,String> myHash=new HashMap<>();
        for (int i = 0; i <arrayList.size() ; i++) {
            String k=arrayList.get(i);
            String[] h= k.split(",");
            myHash.put(h[0],h[1]);
        }
        return myHash;
    }
}
