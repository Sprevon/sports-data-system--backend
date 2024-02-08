package com.tinklebi.sdsb.business.propertyman.service;

import com.tinklebi.sdsb.business.propertyman.entity.po.PropertyManDb;
import com.tinklebi.sdsb.business.propertyman.entity.vo.PropertyMan;
import com.tinklebi.sdsb.utils.HTTPResult;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:23
 */
public interface PropertyManService {
    /**
     * 查询装备管理员
     * @param propertyMan
     * @return
     */
    HTTPResult queryPropertyMan(PropertyMan propertyMan);

    /**
     * 新增装备管理员
     * @param propertyMan
     */
    HTTPResult addPropertyMan(PropertyManDb propertyMan);

    /**
     * 删除装备管理员
     * @param propertyMan
     */
    HTTPResult deletePropertyMan(PropertyManDb propertyMan);

    /**
     * 更新装备管理员信息
     * @param propertyMan
     */
    HTTPResult updatePropertyMan(PropertyManDb propertyMan);
}
