package com.tinklebi.sdsb.business.device.service;

import com.tinklebi.sdsb.business.device.entity.po.DeviceDb;
import com.tinklebi.sdsb.business.device.entity.vo.Device;
import com.tinklebi.sdsb.utils.HTTPResult;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:10
 */
public interface DeviceService {
    HTTPResult queryDevices(Device device);

    HTTPResult addDevice(DeviceDb deviceDb);

    HTTPResult deleteDevice(DeviceDb deviceDb);

    HTTPResult updateDevice(DeviceDb deviceDb);
}
