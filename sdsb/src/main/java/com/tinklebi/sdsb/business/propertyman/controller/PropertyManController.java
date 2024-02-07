package com.tinklebi.sdsb.business.propertyman.controller;

import com.tinklebi.sdsb.business.propertyman.entity.po.PropertyManDb;
import com.tinklebi.sdsb.business.propertyman.entity.vo.PropertyMan;
import com.tinklebi.sdsb.business.propertyman.service.PropertyManService;
import com.tinklebi.sdsb.utils.HTTPResult;
import com.tinklebi.sdsb.utils.LocalSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:22
 */
@RestController
@RequestMapping("/sdsb/propertyMan")
public class PropertyManController {
    @Autowired
    private PropertyManService service;

    @PostMapping(value = "/queryPropertyMan")
    @ResponseBody
    public HTTPResult queryPropertyMan(@RequestBody PropertyMan propertyMan){
        return service.queryPropertyMan(propertyMan);
    }

    @PostMapping(value = "/addPropertyMan")
    @ResponseBody
    public HTTPResult addPropertyMan(@RequestBody PropertyMan propertyMan){
        PropertyManDb propertyManDb = new PropertyManDb(propertyMan, LocalSessionUtils.getOperatorId());
        return service.addPropertyMan(propertyManDb);
    }

    @PostMapping(value = "/deletePropertyMan")
    @ResponseBody
    public HTTPResult deletePropertyMan(@RequestBody PropertyMan propertyMan){
        PropertyManDb propertyManDb = new PropertyManDb(propertyMan, LocalSessionUtils.getOperatorId());
        return service.deletePropertyMan(propertyManDb);
    }

    @PostMapping(value = "/updatePropertyMan")
    @ResponseBody
    public HTTPResult updatePropertyMan(@RequestBody PropertyMan propertyMan){
        PropertyManDb propertyManDb = new PropertyManDb(propertyMan, LocalSessionUtils.getOperatorId());
        return service.updatePropertyMan(propertyManDb);
    }
}
