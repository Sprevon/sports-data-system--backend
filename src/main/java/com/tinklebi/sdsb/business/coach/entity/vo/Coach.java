package com.tinklebi.sdsb.business.coach.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/28 20:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coach implements Serializable {
    private static final long serialVersionUID = -3240160441612764454L;
    /**
     * 教练姓名
     */
    @JsonProperty("cName")
    private String cName;
    /**
     * 教练国籍
     */
    @JsonProperty("cNation")
    private String cNation;
    /**
     * 教练编号
     */
    @JsonProperty("cId")
    private String cId;
}
