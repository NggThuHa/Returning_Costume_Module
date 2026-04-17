package model;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable {
    private String fullname;
    private String email;
    private String tel;
    private String address;
    private String note;

    public Client() {}

    public Client(String fullname, String email, String tel, String address, String note) {
        this.fullname = fullname;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.note = note;
    }

    public List<Client> searchClientByFullname(String fullname) { return null; }
    public List<Client> searchClientByTel(String tel) { return null; }
    public List<Client> searchClientByEmail(String email) { return null; }

    // Getters and Setters
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
