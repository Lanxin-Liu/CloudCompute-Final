package com.anonymco.demo.service;

import com.anonymco.demo.dao.BillDAO;
import com.anonymco.demo.dao.CartDAO;
import com.anonymco.demo.dao.PurchaseDAO;
import com.anonymco.demo.model.Bill;
import com.anonymco.demo.model.Cart;
import com.anonymco.demo.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:40 2019/12/19
 * @version: v1.0
 */
@Service
public class PurchaseService {
    @Autowired
    private CartDAO cartDAO;
    @Autowired
    private BillDAO billDAO;

    public void addToCart(Cart cart) {
        cartDAO.addComToCart(cart);
    }

    public List<Bill> printBill() {
        return billDAO.billList();
    }
}
