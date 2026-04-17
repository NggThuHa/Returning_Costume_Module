package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReturnedCostume implements Serializable {
    private int quantity;
    private Date returnedAt;
    private RentedCostume rentedCostume;
    private List<ReturnedDamage> listReturnedDamage;

    public ReturnedCostume() {}

    public float calculateRentedFee() {
        return 0; // Stub
    }

    // Getters and Setters
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Date getReturnedAt() { return returnedAt; }
    public void setReturnedAt(Date returnedAt) { this.returnedAt = returnedAt; }
    public RentedCostume getRentedCostume() { return rentedCostume; }
    public void setRentedCostume(RentedCostume rentedCostume) { this.rentedCostume = rentedCostume; }
    public List<ReturnedDamage> getListReturnedDamage() { return listReturnedDamage; }
    public void setListReturnedDamage(List<ReturnedDamage> listReturnedDamage) { this.listReturnedDamage = listReturnedDamage; }
}
