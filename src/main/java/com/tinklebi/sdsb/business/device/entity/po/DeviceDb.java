package com.tinklebi.sdsb.business.device.entity.po;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:09
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tinklebi.sdsb.business.device.entity.vo.Device;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class DeviceDb extends Device {

    private static final long serialVersionUID = -7212095738384403544L;
    /**
     * 操作人编号
     */
    @JsonProperty("operatorId")
    private String operatorId;

    public DeviceDb(Device device, String operatorId) {
        super(device.getDeviceId(), device.getDeviceField(), device.getDeviceKind(),
                device.getDeviceState());
        this.operatorId = operatorId;
    }
}

