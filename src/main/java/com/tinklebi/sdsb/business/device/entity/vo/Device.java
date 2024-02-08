package com.tinklebi.sdsb.business.device.entity.vo;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:09
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device implements Serializable {

    private static final long serialVersionUID = -4676782249534628516L;
    /**
     * 设备编号
     */
    @JsonProperty("deviceId")
    private String deviceId;

    /**
     * 设备领域
     */
    @JsonProperty("deviceField")
    private String deviceField;

    /**
     * 设备类型
     */
    @JsonProperty("deviceKind")
    private String deviceKind;

    /**
     * 设备使用状态（0表示未使用，1表示正在使用，2表示维修状态，3表示报废状态）
     */
    @JsonProperty("deviceState")
    private String deviceState;

}
