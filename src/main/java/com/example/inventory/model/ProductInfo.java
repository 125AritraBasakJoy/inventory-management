package com.example.inventory.model;

public abstract class ProductInfo extends BaseProduct implements SpecialDiscount {
    private String category;
    private String brand;

    public ProductInfo(){}

    public ProductInfo(Long id, String name ,double price, String category, String brand) {
        super(id, name, price);
        this.category = category;
        this.brand = brand;
    }

    public abstract double calculateTotalPrice();


    public double getSpecialDiscount(double discountPrice){
        return getPrice() - (getPrice() * discountPrice / 100);
    }

    public double getDiscount(double discountedPrice){
        return getPrice() - (getPrice() * discountedPrice / 100);
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void showInfo() {
        System.out.println("Category: " + category + ", Brand: " + brand);
    }

}
