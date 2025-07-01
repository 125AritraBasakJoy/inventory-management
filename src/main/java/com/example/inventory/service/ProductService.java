package com.example.inventory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.inventory.model.Product;

@Service
public class ProductService {
    private final Map<Long, Product> productMap = new HashMap<>();
    private long currentId = 1;

    public List<Product> getAll() {

        return new ArrayList<>(productMap.values());
    }

    public Product getById(Long id) {
        return productMap.get(id);
    }

    public Product add(Product product) {
        product.setId(currentId++);
        productMap.put(product.getId(), product);
        return product;
    }

    public Product update(Long id, Product updatedProduct) {
        if (!productMap.containsKey(id)) return null;
        updatedProduct.setId(id);
        productMap.put(id, updatedProduct);
        return updatedProduct;
    }

    public void delete(Long id) {

        productMap.remove(id);
    }
}
