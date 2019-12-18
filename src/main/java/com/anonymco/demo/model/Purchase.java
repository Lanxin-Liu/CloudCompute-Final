package com.anonymco.demo.model;

import java.math.BigDecimal;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:21 2019/12/19
 * @version: v1.0
 */
public class Purchase {
    private int productID;
    private int billID;
    private BigDecimal amount;
    private BigDecimal sumprice;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getSumprice() {
        return sumprice;
    }

    public void setSumprice(BigDecimal sumprice) {
        this.sumprice = sumprice;
    }
}
