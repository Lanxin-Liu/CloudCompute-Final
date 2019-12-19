package com.anonymco.demo.controller;

import com.anonymco.demo.dao.BillDAO;
import com.anonymco.demo.dao.CartDAO;
import com.anonymco.demo.dao.CommodityDAO;
import com.anonymco.demo.dao.PurchaseDAO;
import com.anonymco.demo.model.Bill;
import com.anonymco.demo.model.Cart;
import com.anonymco.demo.model.Commodity;
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
    @Autowired
    private PurchaseDAO purchaseDAO;

    @PostMapping("api/purchase")
    @ResponseBody
    public Result purchase(@RequestParam int num) {
        BigDecimal discount = new BigDecimal(num);
        BigDecimal temp = new BigDecimal(0.1);
        discount = discount.multiply(temp);

        List<Cart> toPurchaseCom = cartDAO.cartList();
        Bill bill = new Bill();

        BigDecimal totalp = new BigDecimal("0");

        for(Cart c : toPurchaseCom) {
            Purchase p = new Purchase();
            p.setProductID(c.getProductID());
            p.setAmount(c.getAmount());
            p.setBillID(billDAO.getBillID()+1);
            p.setSumprice(c.getSumprice());
            totalp = totalp.add(p.getSumprice());

            cartDAO.updatePayStatus(c.getCartID());

            Commodity co = commodityDAO.getComByID(c.getProductID());
            BigDecimal newQuan = co.getQuantity().subtract(c.getAmount());
            commodityDAO.updateQuantity(newQuan,c.getProductID());

            purchaseDAO.purchaseFromCart(p);
        }

        Date date = new Date();

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
    public Result addToCart(@RequestParam String name, @RequestParam int temp) {
        BigDecimal amount = new BigDecimal(temp);

        Cart cart = new Cart();

        System.out.println(amount);

        Commodity c = commodityDAO.getComByExactName(name);
        if(c!=null) {
            cart.setAmount(amount);
            cart.setProductID(c.getID());
            cart.setSumprice(amount.multiply(c.getPrice()));

            purchaseService.addToCart(cart);

            return ResultFactory.buildSuccessResult(cart);
        }
        else return ResultFactory.buildFailResult("添加购物车失败！");
    }

    @GetMapping("api/cart")
    @ResponseBody
    public List<Cart> getCartList() {
        return cartDAO.cartList();
    }

    @GetMapping("api/cartvalue")
    @ResponseBody
    public int cartValue() {
        List<Cart> unpayedCart = cartDAO.cartList();
        BigDecimal value = new BigDecimal(0.0);
        for(Cart c:unpayedCart) {
            value = value.add(c.getSumprice());
        }
        return value.intValue();
    }
}
