package com.tinklebi.sdsb.business.device.service.impl;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:11
 */
import com.tinklebi.sdsb.business.device.dao.DeviceMapper;
import com.tinklebi.sdsb.business.device.entity.po.DeviceDb;
import com.tinklebi.sdsb.business.device.entity.vo.Device;
import com.tinklebi.sdsb.business.device.service.DeviceService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public HTTPResult queryDevices(Device device) {
        List<Device> deviceList = deviceMapper.selectDevices(device);
        if (deviceList.isEmpty()) {
            return HTTPResult.buildFault("暂无设备");
        } else {
            return HTTPResult.buildSuccess(deviceList);
        }
    }

    @Override
    public HTTPResult addDevice(DeviceDb deviceDb) {
        Device dbDevice = deviceMapper.selectById(deviceDb);
        if (dbDevice == null) {
            deviceMapper.insertDevice(deviceDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("设备已存在");
        }
    }

    @Override
    public HTTPResult deleteDevice(DeviceDb deviceDb) {
        Device dbDevice = deviceMapper.selectById(deviceDb);
        if (dbDevice != null) {
            deviceMapper.deleteDevice(deviceDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("设备不存在");
        }
    }

    @Override
    public HTTPResult updateDevice(DeviceDb deviceDb) {
        Device dbDevice = deviceMapper.selectById(deviceDb);
        if (dbDevice != null) {
            deviceMapper.updateDevice(deviceDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("设备不存在");
        }
    }
}
