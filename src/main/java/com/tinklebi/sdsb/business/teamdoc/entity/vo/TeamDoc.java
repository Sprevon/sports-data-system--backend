package com.tinklebi.sdsb.business.teamdoc.entity.vo;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:01
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDoc implements Serializable {
    private static final long serialVersionUID = -1234567890123456789L;

    /**
     * 队医编号
     */
    @JsonProperty("docId")
    private Long docId;

    /**
     * 队医名称
     */
    @JsonProperty("docName")
    private String docName;

    /**
     * 队医专业
     */
    @JsonProperty("docMajor")
    private String docMajor;

    /**
     * 队医职位
     */
    @JsonProperty("docPosition")
    private String docPosition;

    /**
     * 队医状态（0表示未上班，1表示正常上班，2表示休假）
     */
    @JsonProperty("docState")
    private String docState;
}
