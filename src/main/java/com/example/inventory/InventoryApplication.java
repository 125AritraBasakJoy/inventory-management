package com.example.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.inventory.model.Product;
import com.example.inventory.service.ProductService;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            Product p1 = new Product(1L, "Pen", 1000.0, 100, "Stationary", "Matador");
            Product p2 = new Product(2L, "Notebook", 1225.0, 50, "Fresh", "Stationary");
            Product p3 = new Product(3L, "Pencil", 1505.0, 200, "Osaka", "Stationary");

            productService.add(p1);
            productService.add(p2);
            productService.add(p3);

            System.out.println("Total value of Pen stock: " + p1.calculateTotalPrice());
            System.out.println("Total value of Notebook stock: " + p2.calculateTotalPrice());
            System.out.println("Total value of Pencil stock: " + p3.calculateTotalPrice());
            System.out.println("Total products created: " + Product.getProductCount());

            System.out.println();

            p1.showDetails();
            p2.showDetails();
            p3.showDetails();

            System.out.println();

            System.out.println("Product: " + p1.getName() + ", Discounted Price: " + p1.getDiscount(10));
            System.out.println("Product: " + p2.getName() + ", Discounted Price: " + p2.getDiscount(10));
            System.out.println("Product: " + p3.getName() + ", Discounted Price: " + p3.getDiscount(10));

            System.out.println();

            System.out.println("Product: " + p1.getName() + ", Discounted Price: " + p1.getSpecialDiscount(15));
            System.out.println("Product: " + p2.getName() + ", Discounted Price: " + p2.getSpecialDiscount(15));
            System.out.println("Product: " + p3.getName() + ", Discounted Price: " + p3.getSpecialDiscount(15));

            System.out.println();

            System.out.println("Is in stock? " + p1.isInStock());
            System.out.println("Is in stock? " + p2.isInStock());
            System.out.println("Is in stock? " + p3.isInStock());

            System.out.println();

            p1.restock(50);
            p2.restock(150);
            p3.restock(20);

            System.out.println();

            p1.sell(30);
            p2.sell(20);
            p3.sell(10);

        };
    }}
