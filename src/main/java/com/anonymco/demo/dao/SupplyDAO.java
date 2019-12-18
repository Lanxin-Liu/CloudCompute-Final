package com.anonymco.demo.dao;

import com.anonymco.demo.model.Supply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:32 2019/12/19
 * @version: v1.0
 */
@Repository
public interface SupplyDAO {
    @Insert("insert into Supply(corID,productID,amount,totalcost,supplydate) values (#{corID},#{productID},#{amount},#{totalcost},#{supplydate})")
    void createSupply(Supply supply);

    @Select("select * from Supply order by supplydate desc")
    List<Supply> getSupplyList();
}
