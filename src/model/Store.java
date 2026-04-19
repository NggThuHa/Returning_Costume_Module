package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Store implements Serializable {
    private int id;
    private String name;
    private String description;
    private String address;
    private String tel;
    private List<Costume> costumes;

    public Store() {
        this.costumes = new ArrayList<>();
    }

    public Store(int id, String name, String description, String address, String tel) {
        this();
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.tel = tel;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Costume> getCostumes() {
        return costumes;
    }

    public void setCostumes(List<Costume> costumes) {
        this.costumes = costumes;
    }
}

