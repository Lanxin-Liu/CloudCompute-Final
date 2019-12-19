package com.anonymco.demo.dao;

import com.anonymco.demo.model.Bill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:31 2019/12/19
 * @version: v1.0
 */
@Repository
public interface BillDAO {
    @Insert("insert into Bill(ID,totalprice,discount,finalprice,date) values(#{ID},#{totalprice},#{discount},#{finalprice},#{date})")
    void createBill(Bill bill);

    //打印订单
    @Select("select * from Bill order by date desc")
    List<Bill> billList();

    @Select("select max(ID) from Bill")
    int getBillID();
}
