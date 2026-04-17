package model;

import java.io.Serializable;

public class Damage implements Serializable {
    private String name;
    private String detail;
    private float fee;
    private String note;

    public Damage() {}

    public Damage(String name, String detail, float fee) {
        this.name = name;
        this.detail = detail;
        this.fee = fee;
    }

    public float getFineFee() { return fee; }
    public void addDamage() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
    public float getFee() { return fee; }
    public void setFee(float fee) { this.fee = fee; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
