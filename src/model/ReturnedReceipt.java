package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReturnedReceipt implements Serializable {
    private String barcode;
    private Date returnedAt;
    private float chargeFee;
    private String note;
    private User user;
    private Client client;
    private List<ReturnedCostume> listReturnedCostume;

    public ReturnedReceipt() {}

    public void calculateTotalReceipt() {}
    public void addReturnedReceipt() {}

    // Getters and Setters
    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
    public Date getReturnedAt() { return returnedAt; }
    public void setReturnedAt(Date returnedAt) { this.returnedAt = returnedAt; }
    public float getChargeFee() { return chargeFee; }
    public void setChargeFee(float chargeFee) { this.chargeFee = chargeFee; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<ReturnedCostume> getListReturnedCostume() { return listReturnedCostume; }
    public void setListReturnedCostume(List<ReturnedCostume> listReturnedCostume) { this.listReturnedCostume = listReturnedCostume; }
}
