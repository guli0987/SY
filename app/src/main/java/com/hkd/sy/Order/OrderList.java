package com.hkd.sy.Order;

public class OrderList {
    private int orderNumber;
    private int foodImage;
    private String foodName;
    private String orderStatus;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderList(int orderNumber, int foodImage, String foodName, String orderStatus) {
        this.orderNumber = orderNumber;
        this.foodImage = foodImage;
        this.foodName = foodName;
        this.orderStatus = orderStatus;
    }
}
