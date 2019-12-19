package com.anonymco.demo.dao;

import com.anonymco.demo.model.Commodity;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @className:
 * @description:
 * @author: Liu Lanxin
 * @date: 01:32 2019/12/19
 * @version: v1.0
 */
@Repository
public interface CommodityDAO {
    @Select("select * from Commodity where corname = #{corname}")
    List<Commodity> getComByCor(String corname);

    @Select("select * from Commodity where locate(#{name},name)>0")
    List<Commodity> getComByName(String name);

    @Select("select * from Commodity where name = #{name}")
    Commodity getComByExactName(String name);

    @Select("select * from Commodity where ID = #{ID}")
    Commodity getComByID(int ID);

    @Select("select * from Commodity where quantity = 0")
    List<Commodity> getLackCom();

    @Update("update Commodity set quantity = #{newQuan} where ID = #{cID}")
    void updateQuantity(BigDecimal newQuan, int cID);

    @Select("select * from Commodity")
    List<Commodity> getComList();
}
