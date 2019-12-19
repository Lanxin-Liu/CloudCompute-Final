package com.anonymco.demo.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:21 2019/12/19
 * @version: v1.0
 */
public class Supply {
    private int corID;
    private int productID;
    private BigDecimal amount;
    private BigDecimal totalcost;
    private Date supplydate;
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCorID() {
        return corID;
    }

    public void setCorID(int corID) {
        this.corID = corID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(BigDecimal totalcost) {
        this.totalcost = totalcost;
    }

    public Date getSupplydate() {
        return supplydate;
    }

    public void setSupplydate(Date supplydate) {
        this.supplydate = supplydate;
    }
}
