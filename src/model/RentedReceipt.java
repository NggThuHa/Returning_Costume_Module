package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentedReceipt implements Serializable {
    private int id;
    private String barcode;
    private Date rentedAt;
    private float saleoff;
    private String status;
    private String note;
    private Client client;
    private User user;
    private List<RentedCostume> listRentedCostume;
    private List<RentedDeposit> listRentedDeposit;

    public RentedReceipt() {
        this.listRentedCostume = new ArrayList<>();
        this.listRentedDeposit = new ArrayList<>();
    }

    public boolean isCompleted() {
        if (listRentedCostume == null || listRentedCostume.isEmpty()) {
            return false;
        }
        for (RentedCostume rentedCostume : listRentedCostume) {
            if (rentedCostume.calculateRemainedQuantity() > 0) {
                return false;
            }
        }
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

    public Date getRentedAt() {
        return rentedAt;
    }

    public void setRentedAt(Date rentedAt) {
        this.rentedAt = rentedAt;
    }

    public float getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(float saleoff) {
        this.saleoff = saleoff;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RentedCostume> getListRentedCostume() {
        return listRentedCostume;
    }

    public void setListRentedCostume(List<RentedCostume> listRentedCostume) {
        this.listRentedCostume = listRentedCostume;
    }

    public List<RentedDeposit> getListRentedDeposit() {
        return listRentedDeposit;
    }

    public void setListRentedDeposit(List<RentedDeposit> listRentedDeposit) {
        this.listRentedDeposit = listRentedDeposit;
    }
}
