package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 4/3/16.
 */
public class OrderDetail {



    String orderId;

    String orderDate;
    String orderAmount;
    String status;
    String groups;
    String savings;

    public String getSavings() {
        return savings;
    }

    public void setSavings(String savings) {
        this.savings = savings;
    }

    public OrderDetail(String orderId, String orderDate, String orderAmount, String status, String groups, String shipCost,String sav) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.status = status;
        this.groups = groups;
        this.shipCost = shipCost;
        this.savings = sav;

    }

    String shipCost;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getShipCost() {
        return shipCost;
    }

    public void setShipCost(String shipCost) {
        this.shipCost = shipCost;
    }
}
