package model;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String fullname;
    private String email;
    private String tel;
    private String address;
    private String note;

    public Client() {
    }

    public Client(int id, String fullname, String email, String tel, String address, String note) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
