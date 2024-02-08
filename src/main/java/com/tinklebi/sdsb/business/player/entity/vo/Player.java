package com.tinklebi.sdsb.business.player.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player implements Serializable {

    private static final long serialVersionUID = 6987603185491944336L;
    /**
     * 运动员编号
     */
    @JsonProperty("plId")
    private Long plId;

    /**
     * 运动员名称
     */
    @JsonProperty("plName")
    private String plName;

    /**
     * 运动员国籍
     */
    @JsonProperty("plNation")
    private String plNation;

    /**
     * 运动员状态（0无异常，1伤缺，2异常）
     */
    @JsonProperty("plState")
    private String plState;

    /**
     * 运动种类
     */
    @JsonProperty("plField")
    private String plField;

    /**
     * 场上位置
     */
    @JsonProperty("plPosition")
    private String plPosition;

    /**
     * 使用设备序号
     */
    @JsonProperty("plDeviceId")
    private Long plDeviceId;
}
