package com.example.supercheap.DeleteSale;

import com.example.supercheap.Classes.User;

public class DeleteSaleModel {
    private DeleteSaleController deleteSaleController;
    private DeleteSale deleteSale;


    public DeleteSaleModel(DeleteSaleController deleteSaleController, DeleteSale deleteSale) {
        this.deleteSale = deleteSale;
        this.deleteSaleController = deleteSaleController;
    }

    public void ValData(String sale_name, User user) {
        if (sale_name.length() == 0) {
            deleteSale.throwNote("bad input");
        } else {
            deleteSaleController.TryDeleteSale(sale_name.toLowerCase(), user);
        }
    }
}
