package com.anonymco.demo.model;

import java.math.BigDecimal;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:19 2019/12/19
 * @version: v1.0
 */
public class Cart {
    private int productID;
    private BigDecimal amount;
    private BigDecimal sumprice;
    private int purchased;
    private int cartID;

    public Cart() {
        this.purchased = 0;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
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

    public BigDecimal getSumprice() {
        return sumprice;
    }

    public void setSumprice(BigDecimal sumprice) {
        this.sumprice = sumprice;
    }

    public int getPurchased() {
        return purchased;
    }

    public void setPurchased(int purchased) {
        this.purchased = purchased;
    }
}
