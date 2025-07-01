package com.example.inventory.model;

public class Product extends ProductInfo implements StockManage {
    private int quantity;
    private static int productCount= 0;

    public Product() {}

    public Product(Long id, String name, double price, int quantity, String category, String brand) {
        super(id, name, price, category, brand);
        this.quantity = quantity;
        productCount++;
    }

    public double calculateTotalPrice() {
        return getPrice() * quantity;
    }

    public boolean isInStock(){
        return quantity > 0;
    }

    public void restock(int amount){
        if (quantity > 0){
        quantity += amount;
            System.out.println(amount + " items are restocked. New Quantity: " + quantity);
        }
        else{
            System.out.println("Invalid restock amount.");
        }
    }

    public void sell(int amount){
        if(amount > 0 && amount <= quantity){
            quantity -= amount;
            System.out.println(amount+ " items are bought. New Quantity: " + quantity);
        }
        else{
            System.out.println("Invalid sell amount.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public static int getProductCount() {
        return productCount;
    }

    public void showDetails() {
        System.out.println("Name: " + getName() + ", Qty: " + quantity);
        System.out.println("Total: " + calculateTotalPrice());
        showInfo();
    }
}
