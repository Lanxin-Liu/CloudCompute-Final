package com.anonymco.demo.controller;

import com.anonymco.demo.dao.BillDAO;
import com.anonymco.demo.dao.CartDAO;
import com.anonymco.demo.dao.CommodityDAO;
import com.anonymco.demo.model.Bill;
import com.anonymco.demo.model.Cart;
import com.anonymco.demo.model.Purchase;
import com.anonymco.demo.result.Result;
import com.anonymco.demo.result.ResultFactory;
import com.anonymco.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 03:37 2019/12/19
 * @version: v1.0
 */
@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private CommodityDAO commodityDAO;
    @Autowired
    private CartDAO cartDAO;
    @Autowired
    private BillDAO billDAO;

    @PostMapping("api/purchase")
    @ResponseBody
    public Result purchase(@RequestParam Date date, @RequestParam BigDecimal discount) {
        List<Cart> toPurchaseCom = cartDAO.cartList();
        Bill bill = new Bill();

        BigDecimal totalp = new BigDecimal("0");

        for(Cart c : toPurchaseCom) {
            Purchase p = new Purchase();
            p.setProductID(c.getProductID());
            p.setAmount(c.getAmount());
            p.setBillID(bill.getID());
            p.setSumprice(c.getSumprice());
            totalp.add(p.getSumprice());
            c.setPurchased(1);
        }

        bill.setDate(date);
        bill.setDiscount(discount);
        bill.setTotalprice(totalp);
        bill.setFinalprice(totalp.multiply(discount));
        billDAO.createBill(bill);

        return ResultFactory.buildSuccessResult(bill);
    }

    @PostMapping("api/billlist")
    @ResponseBody
    public List<Bill> printBill() {
        return billDAO.billList();
    }

    @PostMapping("api/addtocart")
    @ResponseBody
    public Result addToCart(@RequestParam int pID, @RequestParam BigDecimal amount) {
        Cart cart = new Cart();
        cart.setAmount(amount);
        cart.setProductID(pID);
        cart.setSumprice(amount.multiply(commodityDAO.getComByID(pID).getPrice()));

        purchaseService.addToCart(cart);

        return ResultFactory.buildSuccessResult(cart);
    }

    @GetMapping("api/cart")
    @ResponseBody
    public List<Cart> getCartList() {
        return cartDAO.cartList();
    }
}
