package model;

import java.io.Serializable;

public class Damage implements Serializable {
    private int id;
    private String name;
    private String detail;
    private float fee;
    private String note;

    public Damage() {
    }

    public Damage(int id, String name, String detail, float fee, String note) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.fee = fee;
        this.note = note;
    }

    public boolean addDamage() {
        return name != null && !name.trim().isEmpty() && fee >= 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
