package com.example.bt.model;

public class Customer {
    private String name;
    private String bornDate;
    private String address;
    private String imgUrl;

    public Customer() {
    }

    public Customer(String name, String bornDate, String address, String imgUrl) {
        this.name = name;
        this.bornDate = bornDate;
        this.address = address;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
