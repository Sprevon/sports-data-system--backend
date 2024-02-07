package com.tinklebi.sdsb.utils;

import lombok.Setter;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:21
 */
@Setter
public class LocalSessionUtils {
    static private String operatorId;
    static public String getOperatorId(){
        return "1";
    }
}
