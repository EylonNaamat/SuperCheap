package com.example.supercheap.DisplaySale;

public class DisplaySaleModel {
    private DisplaySaleController controller;
    private DisplaySaleView view;

    public DisplaySaleModel(DisplaySaleController controller, DisplaySaleView view) {
        this.controller = controller;
        this.view = view;
    }

    public DisplaySaleController getController() {
        return controller;
    }

    public void setController(DisplaySaleController controller) {
        this.controller = controller;
    }

    public DisplaySaleView getView() {
        return view;
    }

    public void setView(DisplaySaleView view) {
        this.view = view;
    }

    public boolean checkInfo(String super_name, String super_city){
        if(super_name.isEmpty() || super_city.isEmpty()){
            return false;
        }else
            return true;
    }

    public String lowerCase(String word){
        return word.toLowerCase();
    }
}
