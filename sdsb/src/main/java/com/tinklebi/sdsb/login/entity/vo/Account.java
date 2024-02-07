package com.tinklebi.sdsb.login.entity.vo;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:57
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    private static final long serialVersionUID = -7538255937187410063L;
    /**
     * 账号
     */
    @JsonProperty("account")
    private String account;

    /**
     * 密码
     */
    @JsonProperty("password")
    private String password;

    /**
     * 权限
     */
    @JsonProperty("authority")
    private String authority;
}
