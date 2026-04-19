package model;

import java.io.Serializable;

public class RentedDeposit implements Serializable {
    private int id;
    private int quantity;
    private boolean isReturned;
    private String note;
    private DepositItem depositItem;

    public RentedDeposit() {
    }

    public RentedDeposit(int id, int quantity, boolean isReturned, String note, DepositItem depositItem) {
        this.id = id;
        this.quantity = quantity;
        this.isReturned = isReturned;
        this.note = note;
        this.depositItem = depositItem;
    }

    public float getDepositAmount() {
        if (depositItem == null) {
            return 0;
        }
        return depositItem.getValue() * quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public DepositItem getDepositItem() {
        return depositItem;
    }

    public void setDepositItem(DepositItem depositItem) {
        this.depositItem = depositItem;
    }
}
