package com.tinklebi.sdsb.business.playerhealth.entity.vo;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:31
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerHealth implements Serializable {

    private static final long serialVersionUID = 8438787315458057673L;
    /**
     * 运动员编号
     */
    @JsonProperty("plId")
    private Long plId;

    /**
     * 运动员身高
     */
    @JsonProperty("plHeight")
    private Double plHeight;

    /**
     * 运动员体重
     */
    @JsonProperty("plWeight")
    private Double plWeight;

    /**
     * 运动员最大心率
     */
    @JsonProperty("plMaxHeartRate")
    private Long plMaxHeartRate;

    /**
     * 运动员最低心率
     */
    @JsonProperty("plMinHeartRate")
    private Long plMinHeartRate;

    /**
     * 运动员平均心率
     */
    @JsonProperty("plAvgHeartRate")
    private Long plAvgHeartRate;

    /**
     * 运动员运动距离
     */
    @JsonProperty("plTotalDistance")
    private Long plTotalDistance;

    /**
     * 运动员冲刺次数
     */
    @JsonProperty("plSprint")
    private Long plSprint;
}
