package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReturnedReceipt implements Serializable {
    private int id;
    private String barcode;
    private Date returnedAt;
    private float totalRentedFee;
    private float totalFineFee;
    private String note;
    private User user;
    private Client client;
    private List<ReturnedCostume> listReturnedCostume;

    public ReturnedReceipt() {
        this.listReturnedCostume = new ArrayList<>();
    }

    public ReturnedReceipt calculateTotalReceipt(List<ReturnedCostume> list) {
        this.listReturnedCostume = list;
        this.totalRentedFee = 0;
        this.totalFineFee = 0;
        if (list == null) {
            return this;
        }
        for (ReturnedCostume returnedCostume : list) {
            this.totalRentedFee += returnedCostume.getRentedFee();
            this.totalFineFee += returnedCostume.getFineFee();
        }
        return this;
    }

    public int calculateRemainedQuantity(RentedCostume rentedCostume) {
        if (rentedCostume == null) {
            return 0;
        }
        return rentedCostume.calculateRemainedQuantity();
    }

    public float getTotalReceiptFee() {
        return totalRentedFee + totalFineFee;
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

    public Date getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }

    public float getTotalRentedFee() {
        return totalRentedFee;
    }

    public void setTotalRentedFee(float totalRentedFee) {
        this.totalRentedFee = totalRentedFee;
    }

    public float getTotalFineFee() {
        return totalFineFee;
    }

    public void setTotalFineFee(float totalFineFee) {
        this.totalFineFee = totalFineFee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ReturnedCostume> getListReturnedCostume() {
        return listReturnedCostume;
    }

    public void setListReturnedCostume(List<ReturnedCostume> listReturnedCostume) {
        this.listReturnedCostume = listReturnedCostume;
    }
}
