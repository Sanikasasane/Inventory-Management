package com.example.inventorymanagement;

public class Category {

    private int id; // Unique identifier for the category (optional)
    private String name;
    private String description; // Optional field to store a description
    private String imageUrl; // URL for the category image (optional)

    // Getters and Setters (omitted for brevity)

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category(int id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Category(){

    }

    // Optional: Create constructors without all arguments if needed
}
