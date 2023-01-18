package com.example.supercheap.Manager;

import com.example.supercheap.Classes.User;

public class ManagerModel {
    private ControllerManager MController;
    private ManagerPage managerPage;


    public ManagerModel(ControllerManager controllerManager, ManagerPage managerPage) {
        this.MController = controllerManager;
        this.managerPage = managerPage;
    }

    public void ValData(String itemName, String price, String company, User user) {
        if (itemName.length() == 0 || price.length() == 0 || company.length() == 0) {
            managerPage.throwNote("bad input");
        } else {
            MController.TryInsert(itemName.toLowerCase(), price.toLowerCase(), company.toLowerCase(), user);
        }
    }
}
