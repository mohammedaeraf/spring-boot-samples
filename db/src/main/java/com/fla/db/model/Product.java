package com.fla.db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// POJO - Plain Old Java Object representing a Product entity

@Entity // Marks this class as a JPA entity mapped to a database table
public class Product {

    @Id // Specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID value using the database identity column
    private Long id;

    private String title; // Product title
    private double price; // Product price
    private String brand;
    private String category;

    public Product() {
        // Default constructor required by JPA
    }

    public Product(Long id, String title, double price, String brand, String category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }

    public Long getId() {
        return id; // Returns the product ID
    }

    public void setId(Long id) {
        this.id = id; // Sets the product ID
    }

    public String getTitle() {
        return title; // Returns the product title
    }

    public void setTitle(String title) {
        this.title = title; // Sets the product title
    }

    public double getPrice() {
        return price; // Returns the product price
    }

    public void setPrice(double price) {
        this.price = price; // Sets the product price
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}