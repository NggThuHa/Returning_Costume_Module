package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentedCostume implements Serializable {
    private int id;
    private float price;
    private int quantity;
    private float saleoff;
    private int returnedQuantity;
    private Date rentedAt;
    private Costume costume;
    private List<RentedDamage> listRentedDamage;

    public RentedCostume() {
        this.listRentedDamage = new ArrayList<>();
    }

    public RentedCostume(int id, float price, int quantity, float saleoff, Costume costume) {
        this();
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.saleoff = saleoff;
        this.costume = costume;
    }

    public int calculateRemainedQuantity() {
        return Math.max(0, quantity - returnedQuantity);
    }

    public void addReturnedQuantity(int quantityToAdd) {
        if (quantityToAdd <= 0) {
            return;
        }
        this.returnedQuantity = Math.min(this.quantity, this.returnedQuantity + quantityToAdd);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(float saleoff) {
        this.saleoff = saleoff;
    }

    public int getReturnedQuantity() {
        return returnedQuantity;
    }

    public void setReturnedQuantity(int returnedQuantity) {
        this.returnedQuantity = Math.max(0, Math.min(quantity, returnedQuantity));
    }

    public Date getRentedAt() {
        return rentedAt;
    }

    public void setRentedAt(Date rentedAt) {
        this.rentedAt = rentedAt;
    }

    public Costume getCostume() {
        return costume;
    }

    public void setCostume(Costume costume) {
        this.costume = costume;
    }

    public List<RentedDamage> getListRentedDamage() {
        return listRentedDamage;
    }

    public void setListRentedDamage(List<RentedDamage> listRentedDamage) {
        this.listRentedDamage = listRentedDamage;
    }
}
