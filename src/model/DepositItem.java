package model;

import java.io.Serializable;

public class DepositItem implements Serializable {
    private int id;
    private String name;
    private float value;
    private String note;

    public DepositItem() {
    }

    public DepositItem(int id, String name, float value, String note) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.note = note;
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
