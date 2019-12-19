package com.anonymco.demo.dao;

import com.anonymco.demo.model.Corporation;
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
public interface CorporationDAO {
    @Select("select * from Corporation where locate(#{name},name)>0")
    List<Corporation> corp(String name);
}
