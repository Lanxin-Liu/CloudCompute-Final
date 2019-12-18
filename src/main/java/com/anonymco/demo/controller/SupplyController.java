package com.anonymco.demo.controller;

import com.anonymco.demo.dao.CommodityDAO;
import com.anonymco.demo.dao.CorporationDAO;
import com.anonymco.demo.model.Commodity;
import com.anonymco.demo.model.Supply;
import com.anonymco.demo.result.Result;
import com.anonymco.demo.result.ResultFactory;
import com.anonymco.demo.service.SupplyService;
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
 * @date: 02:18 2019/12/19
 * @version: v1.0
 */
@Controller
public class SupplyController {
    @Autowired
    private SupplyService supplyService;
    @Autowired
    private CorporationDAO corporationDAO;
    @Autowired
    private CommodityDAO commodityDAO;

    @GetMapping("api/corlist")
    @ResponseBody
    public List<Commodity> corCommodityList(@RequestParam String name) {
        return supplyService.getComByCor(name);
    }

    @GetMapping("api/namelist")
    @ResponseBody
    public List<Commodity> nameCommodityList(@RequestParam String name) {
        return supplyService.getComByName(name);
    }

    @PostMapping("api/supply")
    @ResponseBody
    public Result newSupply(@RequestParam BigDecimal amount, @RequestParam Date date, @RequestParam String pName, @RequestParam String cName) {
        int cID = corporationDAO.corp(cName).get(0).getID();
        int pID = commodityDAO.getComByExactName(pName).getID();

        Commodity c = commodityDAO.getComByExactName(pName);

        Supply supply = new Supply();
        supply.setAmount(amount);
        supply.setCorID(cID);
        supply.setProductID(pID);
        supply.setSupplydate(date);
        supply.setTotalcost(c.getPrice().multiply(amount));
        supplyService.addSupply(supply);

        c.setQuantity(c.getQuantity().add(amount));

        return ResultFactory.buildSuccessResult(supply);
    }
}
