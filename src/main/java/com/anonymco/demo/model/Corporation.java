package com.anonymco.demo.model;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:21 2019/12/19
 * @version: v1.0
 */
public class Corporation {
    private int ID;
    private String name;
    private String address;
    private String country;
    private String business;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
}
