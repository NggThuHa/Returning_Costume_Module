package model;

import java.io.Serializable;

public class ReturnedDamage implements Serializable {
    private float fee;
    private int quantity;
    private boolean isPaid;
    private Damage damage;

    public ReturnedDamage() {}

    public void addDamageReturned() {}

    // Getters and Setters
    public float getFee() { return fee; }
    public void setFee(float fee) { this.fee = fee; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public boolean getIsPaid() { return isPaid; }
    public void setIsPaid(boolean isPaid) { this.isPaid = isPaid; }
    public Damage getDamage() { return damage; }
    public void setDamage(Damage damage) { this.damage = damage; }
}
