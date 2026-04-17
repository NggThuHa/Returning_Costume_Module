package model;

import java.io.Serializable;

public class RentedCostume implements Serializable {
    private float price;
    private int quantity;
    private float saleoff;
    private boolean isReturned;
    private Costume costume;

    public RentedCostume() {}

    public void updateRentedStatus() {
        this.isReturned = true;
    }

    // Getters and Setters
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public float getSaleoff() { return saleoff; }
    public void setSaleoff(float saleoff) { this.saleoff = saleoff; }
    public boolean getIsReturned() { return isReturned; }
    public void setIsReturned(boolean isReturned) { this.isReturned = isReturned; }
    public Costume getCostume() { return costume; }
    public void setCostume(Costume costume) { this.costume = costume; }
}
