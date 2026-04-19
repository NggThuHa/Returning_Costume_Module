package model;

import java.io.Serializable;

public class ReturnedDamage implements Serializable {
    private int id;
    private float fee;
    private int quantity;
    private boolean isPaid;
    private Damage damage;

    public ReturnedDamage() {
    }

    public ReturnedDamage(int id, float fee, int quantity, boolean isPaid, Damage damage) {
        this.id = id;
        this.fee = fee;
        this.quantity = quantity;
        this.isPaid = isPaid;
        this.damage = damage;
    }

    public float getTotalFineFee() {
        return fee * quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }
}
