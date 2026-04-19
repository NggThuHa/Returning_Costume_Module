package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReturnedCostume implements Serializable {
    private int id;
    private int quantity;
    private Date returnedAt;
    private RentedCostume rentedCostume;
    private List<ReturnedDamage> listReturnedDamage;

    public ReturnedCostume() {
        this.listReturnedDamage = new ArrayList<>();
    }

    public float calculateRentedFee(Date returnedAt, Date rentedAt, int quantity) {
        if (rentedCostume == null || quantity <= 0 || returnedAt == null || rentedAt == null) {
            return 0;
        }
        long milliseconds = Math.max(0, returnedAt.getTime() - rentedAt.getTime());
        long days = Math.max(1, milliseconds / (24L * 60 * 60 * 1000));
        return rentedCostume.getPrice() * quantity * days;
    }

    public boolean addReturnedDamage(ReturnedCostume target, Damage damage) {
        if (target == null || damage == null) {
            return false;
        }
        ReturnedDamage returnedDamage = new ReturnedDamage();
        returnedDamage.setDamage(damage);
        returnedDamage.setFee(damage.getFee());
        returnedDamage.setQuantity(1);
        target.getListReturnedDamage().add(returnedDamage);
        return true;
    }

    public float getRentedFee() {
        Date rentedAt = rentedCostume != null ? rentedCostume.getRentedAt() : null;
        if (rentedCostume != null && rentedCostume.getCostume() != null && returnedAt != null && rentedAt != null) {
            return calculateRentedFee(returnedAt, rentedAt, quantity);
        }
        return 0;
    }

    public float getFineFee() {
        float total = 0;
        if (listReturnedDamage == null) {
            return total;
        }
        for (ReturnedDamage returnedDamage : listReturnedDamage) {
            total += returnedDamage.getTotalFineFee();
        }
        return total;
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

    public Date getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }

    public RentedCostume getRentedCostume() {
        return rentedCostume;
    }

    public void setRentedCostume(RentedCostume rentedCostume) {
        this.rentedCostume = rentedCostume;
    }

    public List<ReturnedDamage> getListReturnedDamage() {
        return listReturnedDamage;
    }

    public void setListReturnedDamage(List<ReturnedDamage> listReturnedDamage) {
        this.listReturnedDamage = listReturnedDamage;
    }
}
