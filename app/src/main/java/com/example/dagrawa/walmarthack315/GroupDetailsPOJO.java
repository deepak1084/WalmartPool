package com.example.dagrawa.walmarthack315;

/**
 * Created by sushant on 4/16/16.
 */
public class GroupDetailsPOJO {

    private String id;
    private String ownerName;
    private String name;
    private String address;
    private float total;

    public boolean isBox() {
        return box;
    }

    public void setBox(boolean box) {
        this.box = box;
    }

    private boolean box;

    public GroupDetailsPOJO(){
        super();
    }

    public GroupDetailsPOJO(String id, String ownerName, String name, String address, float total,boolean box) {
        this.id = id;
        this.ownerName = ownerName;
        this.name = name;
        this.address = address;
        this.total = total;
        this.box = box;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "GroupDetailsPOJO{" +
                "id='" + id + '\'' +
                "ownerName='" + ownerName + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
