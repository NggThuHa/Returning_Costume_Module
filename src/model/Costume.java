package model;

import java.io.Serializable;

public class Costume implements Serializable {
    private String barcode;
    private String name;
    private String color;
    private String size;
    private String description;
    private int quantity;
    private float price;
    private String zone;

    public Costume() {}

    public void updateQuantity(int newQty) {
        this.quantity = newQty;
    }

    // Getters and Setters
    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }
}
