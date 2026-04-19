package model;

import java.io.Serializable;

public class Costume implements Serializable {
    private int id;
    private String barcode;
    private String name;
    private String color;
    private String size;
    private String description;
    private float price;
    private int quantity;
    private String zone;
    private Store store;

    public Costume() {
    }

    public Costume(int id, String barcode, String name, String color, String size, String description,
                   float price, int quantity, String zone) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.color = color;
        this.size = size;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.zone = zone;
    }

    public boolean updateQuantity(int returnQuantity) {
        if (returnQuantity <= 0) {
            return false;
        }
        this.quantity += returnQuantity;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
