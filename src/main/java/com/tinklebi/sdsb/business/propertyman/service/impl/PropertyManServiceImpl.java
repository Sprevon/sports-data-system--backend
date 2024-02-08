package com.tinklebi.sdsb.business.propertyman.service.impl;

import com.tinklebi.sdsb.business.propertyman.dao.PropertyManMapper;
import com.tinklebi.sdsb.business.propertyman.entity.po.PropertyManDb;
import com.tinklebi.sdsb.business.propertyman.entity.vo.PropertyMan;
import com.tinklebi.sdsb.business.propertyman.service.PropertyManService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PropertyManServiceImpl implements PropertyManService {
    @Autowired
    private PropertyManMapper propertyManMapper;

    /**
     * 查询装备管理员
     *
     * @param propertyMan
     * @return
     */
    @Override
    public HTTPResult queryPropertyMan(PropertyMan propertyMan) {
        List<PropertyMan> propertyManList = propertyManMapper.selectPropertyMan(propertyMan);
        if (propertyManList.isEmpty()){
            return HTTPResult.buildFault("暂无装备管理员信息");
        } else {
            return HTTPResult.buildSuccess(propertyManList);
        }
    }

    /**
     * 新增装备管理员
     *
     * @param propertyManDb
     */
    @Override
    public HTTPResult addPropertyMan(PropertyManDb propertyManDb) {
        PropertyMan dbPropertyMan = propertyManMapper.selectById(propertyManDb);
        if (dbPropertyMan == null){
            propertyManMapper.insertPropertyMan(propertyManDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("装备管理员已存在");
        }
    }

    /**
     * 删除装备管理员
     *
     * @param propertyManDb
     */
    @Override
    public HTTPResult deletePropertyMan(PropertyManDb propertyManDb) {
        PropertyMan dbPropertyMan = propertyManMapper.selectById(propertyManDb);
        if (dbPropertyMan != null){
            propertyManMapper.deletePropertyMan(propertyManDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("装备管理员不存在");
        }
    }

    /**
     * 更新装备管理员信息
     *
     * @param propertyManDb
     */
    @Override
    public HTTPResult updatePropertyMan(PropertyManDb propertyManDb) {
        PropertyMan dbPropertyMan = propertyManMapper.selectById(propertyManDb);
        if (dbPropertyMan != null){
            propertyManMapper.updatePropertyMan(propertyManDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("装备管理员不存在");
        }
    }
}
