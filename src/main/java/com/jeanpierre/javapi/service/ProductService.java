package com.jeanpierre.javapi.service;

import com.jeanpierre.javapi.model.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductService {

    List<Product> productList = new ArrayList<>();
    int ctx = 0;

    public void addProducts(String name, String description, int price, String date) {
        this.ctx++;
        productList.add(new Product(ctx, name, description, price, date));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public List<Product> getProductsById(int id) {
        List<Product> matchingProducts = new ArrayList<>();
        if (productList != null) {
            for (Product product : productList) {
                if (product != null && product.getId() == id) {
                    matchingProducts.add(product);
                }
            }
        }
        return matchingProducts.isEmpty() ? null : matchingProducts;
    }

     public void deleteById(int id) {
        for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
