package com.anonymco.demo.model;

import java.math.BigDecimal;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:21 2019/12/19
 * @version: v1.0
 */
public class Commodity {
    private int ID;
    private String name;
    private BigDecimal quantity;
    private BigDecimal price;
    private String corname;

    public String getCorname() {
        return corname;
    }

    public void setCorname(String corname) {
        this.corname = corname;
    }

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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
