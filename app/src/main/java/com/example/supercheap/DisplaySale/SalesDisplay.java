package com.example.supercheap.DisplaySale;

public class SalesDisplay {
    private String sale_name;
    private String item;
    private String company;
    private String quantity;
    private String price;

    public SalesDisplay(String sale_name, String item, String company, String quantity, String price) {
        this.sale_name = sale_name;
        this.item = item;
        this.company = company;
        this.quantity = quantity;
        this.price = price;
    }

    public String getSale_name() {
        return sale_name;
    }

    public void setSale_name(String sale_name) {
        this.sale_name = sale_name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SalesDisplay{" +
                "sale_name='" + sale_name + '\'' +
                ", item='" + item + '\'' +
                ", company='" + company + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
