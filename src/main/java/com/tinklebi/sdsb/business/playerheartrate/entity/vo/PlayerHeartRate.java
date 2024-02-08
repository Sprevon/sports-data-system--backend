package com.tinklebi.sdsb.business.playerheartrate.entity.vo;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:38
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerHeartRate implements Serializable {

    private static final long serialVersionUID = 3807271988281820692L;
    /**
     * 运动员编号
     */
    @JsonProperty("plId")
    private Long plId;

    /**
     * 运动员平均心率
     */
    @JsonProperty("plCurrentHeartRate")
    private Long plCurrentHeartRate;

    /**
     * 创建时间
     */
    @JsonProperty("createDate")
    private String createDate;
}
