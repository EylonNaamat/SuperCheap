package com.example.supercheap.Sale;

import com.example.supercheap.Classes.User;

public class SaleModel {
    private SaleController saleController;
    private SaleView saleView;

    public SaleModel(SaleController saleController, SaleView saleView) {
        this.saleController = saleController;
        this.saleView = saleView;
    }

    public void ValData(String saleName, String company, String quantity, String price, User user) {
        if (saleName.length() == 0 || company.length() == 0 || quantity.length() == 0 || price.length() == 0) {
            saleView.throwNote("At least one input is empty");
        } else {
            saleController.TrySale(saleName.toLowerCase(), company.toLowerCase(), quantity, price, user);
        }
    }
}
