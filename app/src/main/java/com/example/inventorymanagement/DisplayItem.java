package com.example.inventorymanagement;

public class DisplayItem {

    private String imageUrl; // URL for the item image
    private String name;
    private String price; // Price of the item

    // Getters and Setters (omitted for brevity)

    public DisplayItem(String imageUrl, String name, String price) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public DisplayItem() {
    }
// Optional: Create constructors without all arguments
}

