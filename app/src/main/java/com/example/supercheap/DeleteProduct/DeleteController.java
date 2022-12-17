package com.example.supercheap.DeleteProduct;

import com.example.supercheap.Classes.User;
import com.example.supercheap.Manager.ManagerModel;
import com.example.supercheap.Manager.ManagerPage;

public class DeleteController {
    private DeleteProductsActivity my_manager_view;
    private DeleteModel my_del_mod;
    public DeleteController(DeleteProductsActivity managerPage) {
        this.my_del_mod = new DeleteModel(this);
        this.my_manager_view = managerPage;
    }

    public void Done(String s){my_manager_view.throwNote(s);}


    public void TryDelete(String itemName, String company, User user) {
        if (itemName.length() == 0 || company.length() == 0) {
            my_manager_view.throwNote("bad input");
        } else {
            my_del_mod.DoDelete(itemName, company, user);
        }
    }
}