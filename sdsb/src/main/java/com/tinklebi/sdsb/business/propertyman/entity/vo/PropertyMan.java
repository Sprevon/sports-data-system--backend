package com.tinklebi.sdsb.business.propertyman.entity.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyMan implements Serializable {

    private static final long serialVersionUID = -8204848182415068450L;
    /**
     * 识别信息
     */
    @JsonProperty("propId")
    private Long propId;

    /**
     * 姓名
     */
    @JsonProperty("propName")
    private String propName;

    /**
     * 管理员工作状态（0表示未上班，1表示正常上班，2表示休假）
     */
    @JsonProperty("propState")
    private String propState;

    /**
     * 装备管理员负责的装备室号码
     */
    @JsonProperty("propRoomId")
    private Long propRoomId;

}
