package com.anonymco.demo.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:20 2019/12/19
 * @version: v1.0
 */
public class Bill {
    private int ID;
    private BigDecimal totalprice;
    private BigDecimal discount;
    private BigDecimal finalprice;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getFinalprice() {
        return finalprice;
    }

    public void setFinalprice(BigDecimal finalprice) {
        this.finalprice = finalprice;
    }

}
