package com.anonymco.demo.dao;

import com.anonymco.demo.model.Purchase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:32 2019/12/19
 * @version: v1.0
 */
@Repository
public interface PurchaseDAO {
    @Insert("insert into Purchase(productID,billID,amount,sumprice) values (#{productID},#{billID},#{amount},#{sumprice})")
    void purchaseFromCart(Purchase p);
}
