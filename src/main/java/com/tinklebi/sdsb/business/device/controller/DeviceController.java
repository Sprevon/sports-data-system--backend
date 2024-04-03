package com.tinklebi.sdsb.business.device.controller;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:11
 */
import com.tinklebi.sdsb.business.device.entity.po.DeviceDb;
import com.tinklebi.sdsb.business.device.entity.vo.Device;
import com.tinklebi.sdsb.business.device.service.DeviceService;
import com.tinklebi.sdsb.utils.HTTPResult;
import com.tinklebi.sdsb.utils.LocalSessionUtils;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdsb/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping(value = "/queryDevices")
    @ResponseBody
    public HTTPResult queryDevices(@RequestBody Device device) {
        return deviceService.queryDevices(device);
    }

    @PostMapping(value = "/addDevice")
    @ResponseBody
    public HTTPResult addDevice(@RequestBody Device device) {
        DeviceDb deviceDb = new DeviceDb(device, LocalSessionUtils.getOperatorId());
        return deviceService.addDevice(deviceDb);
    }

    @PostMapping(value = "/deleteDevice")
    @ResponseBody
    public HTTPResult deleteDevice(@RequestBody Device device) {
        DeviceDb deviceDb = new DeviceDb(device, LocalSessionUtils.getOperatorId());
        return deviceService.deleteDevice(deviceDb);
    }

    @PostMapping(value = "/updateDevice")
    @ResponseBody
    public HTTPResult updateDevice(@RequestBody Device device) {
        DeviceDb deviceDb = new DeviceDb(device, LocalSessionUtils.getOperatorId());
        return deviceService.updateDevice(deviceDb);
    }

    @PostMapping(value = "/test")
    @ResponseBody
    public String testDevice(){
        Log log = LogFactory.getLog(DeviceController.class);
        log.trace("Tracing!!!");
        return "device test";
    }
}
