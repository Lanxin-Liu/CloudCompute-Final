package com.anonymco.demo.service;

import com.anonymco.demo.dao.CommodityDAO;
import com.anonymco.demo.dao.SupplyDAO;
import com.anonymco.demo.model.Commodity;
import com.anonymco.demo.model.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className:
 * @description: 进货-1.列出商家所有产品-2.进货-3.进货列表
 * @author: Liu Lanxin
 * @date: 01:40 2019/12/19
 * @version: v1.0
 */
@Service
public class SupplyService {
    @Autowired
    private CommodityDAO commodityDAO;
    @Autowired
    private SupplyDAO supplyDAO;

    public List<Commodity> getComByCor(String name) {
        return commodityDAO.getComByCor(name);
    }

    public List<Commodity> getComByName(String name) {
        return commodityDAO.getComByName(name);
    }

    //进货：需要前端amount，date，productID，corID
    public void addSupply(Supply supply) {
        supplyDAO.createSupply(supply);
    }

    public List<Supply> supplyList() {
        return supplyDAO.getSupplyList();
    }
}
