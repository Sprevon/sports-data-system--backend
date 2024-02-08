package com.tinklebi.sdsb.business.device.dao;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:10
 */
import com.tinklebi.sdsb.business.device.entity.po.DeviceDb;
import com.tinklebi.sdsb.business.device.entity.vo.Device;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper {
    List<Device> selectDevices(Device deviceCondition);

    Device selectById(DeviceDb deviceDb);

    void insertDevice(DeviceDb deviceDb);

    void deleteDevice(Device device);

    void updateDevice(DeviceDb deviceDb);
}
