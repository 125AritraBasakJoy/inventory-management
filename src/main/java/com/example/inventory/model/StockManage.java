package com.example.inventory.model;

public interface StockManage {
    boolean isInStock();
    void restock(int amount);
    void sell(int amount);
}
