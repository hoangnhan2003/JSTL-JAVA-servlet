package com.example.demo.model;

public class Product {
    private String nameProduct;
    private float price;
    private int quantity;
    private String color;
    Category category;

    public Product(String nameProduct, float price, int quantity, String color, Category category) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product() {
    }

    public Product(String nameProduct, float price, int quantity, String color) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
