package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RentedReceipt implements Serializable {
    private String barcode;
    private Date rentedAt;
    private float saleoff;
    private String note;
    private Client client;
    private User user;
    private List<RentedCostume> listRentedCostume;

    public RentedReceipt() {}

    public List<RentedReceipt> searchByClient(Client client) { return null; }

    // Getters and Setters
    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
    public Date getRentedAt() { return rentedAt; }
    public void setRentedAt(Date rentedAt) { this.rentedAt = rentedAt; }
    public float getSaleoff() { return saleoff; }
    public void setSaleoff(float saleoff) { this.saleoff = saleoff; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public List<RentedCostume> getListRentedCostume() { return listRentedCostume; }
    public void setListRentedCostume(List<RentedCostume> listRentedCostume) { this.listRentedCostume = listRentedCostume; }
}
