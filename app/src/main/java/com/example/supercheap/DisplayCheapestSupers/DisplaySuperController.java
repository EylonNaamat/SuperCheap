package com.example.supercheap.DisplayCheapestSupers;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class DisplaySuperController {
    static int counter_checked = 0;
    ArrayList<SuperDisplay> supers;
    private DisplaySuperModel model;
    private MainPageDisplay view;
    HashMap<String,String> item_list;
    // if array size is n call view to display


    public DisplaySuperController(MainPageDisplay view, HashMap<String,String> item_list) {
        this.supers = new ArrayList<>();
        this.model = new DisplaySuperModel(this);
        this.view = view;
        this.item_list = item_list;
    }

    public static int getCounter_checked() {
        return counter_checked;
    }

    public static void setCounter_checked(int counter_checked) {
        DisplaySuperController.counter_checked = counter_checked;
    }

    public ArrayList<SuperDisplay> getSupers() {
        return supers;
    }

    public void setSupers(ArrayList<SuperDisplay> supers) {
        this.supers = supers;
    }

    public DisplaySuperModel getModel() {
        return model;
    }

    public void setModel(DisplaySuperModel model) {
        this.model = model;
    }

    public MainPageDisplay getView() {
        return view;
    }

    public void setView(MainPageDisplay view) {
        this.view = view;
    }

    public HashMap<String, String> getItem_list() {
        return item_list;
    }

    public void setItem_list(HashMap<String, String> item_list) {
        this.item_list = item_list;
    }


    public void fillSupers(String city){
        model.getSupers(city);
    }

    public void failSearch(String error){
        view.promptError(error);
    }

    public void createHash(ArrayList<String> super_ids){
        // for every super id in the city that was asked calls model to calculate the cart, giving the model func
        // the super id (singular) and the list the customer inserted
        for(int i = 0; i < super_ids.size(); ++i){
            model.calculateCart(super_ids.get(i), this.item_list);
        }
        // after filling the array list to be displayed in view, we first sort it and then sending it to the view
        sortSupers();
        view.showSupers(this.supers);
    }

    public void addPriceToList(String super_name, int missing_items, int substitute_item, int total_price){
        // creating the super display according to the model info
        // and adding this done super to the arraylist to be presented in view
        SuperDisplay new_super = new SuperDisplay(super_name, String.valueOf(missing_items), String.valueOf(substitute_item), String.valueOf(total_price));
        this.supers.add(new_super);
    }

    // sorting function
    // priority 1 is the number of missing items
    // priority 2 is the number of substitute items
    // priority 3 is the cart total price
    public void sortSupers(){
        Collections.sort(this.supers, new Comparator<SuperDisplay>() {
            @Override
            public int compare(SuperDisplay o1, SuperDisplay o2) {
                if(Integer.parseInt(o1.getMissing_items()) < Integer.parseInt(o2.getMissing_items())){
                    return 1;
                }else if(Integer.parseInt(o1.getMissing_items()) == Integer.parseInt(o2.getMissing_items())){
                    if(Integer.parseInt(o1.getSubstitute_item()) < Integer.parseInt(o2.getSubstitute_item())){
                        return 1;
                    }else if(Integer.parseInt(o1.getSubstitute_item()) == Integer.parseInt(o2.getSubstitute_item())){
                        if(Integer.parseInt(o1.getTotal_price()) < Integer.parseInt(o2.getTotal_price())){
                            return 1;
                        }else if(Integer.parseInt(o1.getTotal_price()) == Integer.parseInt(o2.getTotal_price())){
                            return 0;
                        }
                    }
                }
                return -1;
            }
        });
    }
}
