package com.jeanpierre.javapi.model;

public class Product {

    private int id;
    private String name;
    private String description;
    private int price;
    private String dateAt;

    public Product() {
    }

    public Product(int id, String name, String description, int price, String dateAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dateAt = dateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateAt() {
        return dateAt;
    }

    public void setDateAt(String dateAt) {
        this.dateAt = dateAt;
    }
}
