package com.tinklebi.sdsb.business.propertyman.dao;

import com.tinklebi.sdsb.business.propertyman.entity.po.PropertyManDb;
import com.tinklebi.sdsb.business.propertyman.entity.vo.PropertyMan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:21
 */
@Mapper
public interface PropertyManMapper {
    /**
     * 查询装备管理员
     * @param propertyManCondition
     * @return
     */
    List<PropertyMan> selectPropertyMan(PropertyMan propertyManCondition);

    /**
     * 根据Id查询装备管理员
     * @param propertyMan
     * @return
     */
    PropertyMan selectById(PropertyManDb propertyMan);

    /**
     * 插入装备管理员信息
     * @param propertyManInfo
     */
    void insertPropertyMan(PropertyManDb propertyManInfo);

    /**
     * 删除装备管理员
     * @param propertyManInfo
     */
    void deletePropertyMan(PropertyMan propertyManInfo);

    /**
     * 更新装备管理员信息
     * @param propertyManInfo
     */
    void updatePropertyMan(PropertyManDb propertyManInfo);
}
