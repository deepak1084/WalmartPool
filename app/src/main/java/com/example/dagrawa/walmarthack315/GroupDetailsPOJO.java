package com.example.dagrawa.walmarthack315;

/**
 * Created by sushant on 4/16/16.
 */
public class GroupDetailsPOJO {

    private String id;
    private String ownerName;
    private String name;
    private String address;


    public GroupDetailsPOJO(String id, String ownerName, String name, String address) {
        this.id = id;
        this.ownerName = ownerName;
        this.name = name;
        this.address = address;
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

    @Override
    public String toString() {
        return "GroupDetailsPOJO{" +
                "id='" + id + '\'' +
                "ownerName='" + ownerName + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
