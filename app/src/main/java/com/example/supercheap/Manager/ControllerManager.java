package com.example.supercheap.Manager;

import com.example.supercheap.Classes.User;

public class ControllerManager {
    private ManagerPage my_manager_view;
    private ManagerModel my_man_mod;
    public ControllerManager(ManagerPage managerPage) {
        this.my_man_mod=new ManagerModel(this);
        this.my_manager_view=managerPage;
    }



    public void TryInsert(String itemName, String price, String company, User user) {
        if (itemName.length() == 0 || price.length() == 0 || company.length() == 0) {
            my_manager_view.throwNote("bad input");
        } else {
            my_man_mod.DoInsert(itemName, Double.parseDouble(price), company, user);
        }
    }
    public void TryUpdate(String saleName, String saleQuantity, String priceSale, String company, User user) {
        if (saleName.length() == 0 || priceSale.length() == 0 ||saleQuantity.length()==0|| company.length() == 0) {
            my_manager_view.throwNote("bad input");
        } else {
            my_man_mod.DoSale(saleName, Integer.parseInt(saleQuantity), Double.parseDouble(priceSale), company, user);
        }
    }
    public void NoItem(){my_manager_view.throwNote("Error");}
    public void Done(String s){my_manager_view.throwNote(s);}
}
