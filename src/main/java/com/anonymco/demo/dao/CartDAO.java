package com.anonymco.demo.dao;

import com.anonymco.demo.model.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
public interface CartDAO {
    @Insert("insert into Cart(productID,amount,sumprice,purchased) values (#{productID},#{amount},#{sumprice},#{purchased})")
    void addComToCart(Cart cart);

    @Select("select * from Cart where purchased = 0")
    List<Cart> cartList();

    @Select("select * from Cart where purchased = 1")
    List<Cart> purchasedCartList();

    @Update("update Cart set purchased = 1 where cartID = #{cartID}")
    void updatePayStatus(int cartID);
}
