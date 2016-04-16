package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 4/16/16.
 */
public class GroupFetchAtShippingPage {
    String name;
    String grpId;
    String adress;
    String zipCode;
    String grpTotal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrpId() {
        return grpId;
    }

    public GroupFetchAtShippingPage(String name, String grpId, String adress, String zipCode, String grpTotal) {
        this.name = name;
        this.grpId = grpId;
        this.adress = adress;
        this.zipCode = zipCode;
        this.grpTotal = grpTotal;
    }

    public void setGrpId(String grpId) {
        this.grpId = grpId;

    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getGrpTotal() {
        return grpTotal;
    }

    public void setGrpTotal(String grpTotal) {
        this.grpTotal = grpTotal;
    }
}
