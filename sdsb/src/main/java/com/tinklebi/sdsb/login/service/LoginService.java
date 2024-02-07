package com.tinklebi.sdsb.login.service;

import com.tinklebi.sdsb.login.entity.vo.Account;
import com.tinklebi.sdsb.utils.HTTPResult;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 21:05
 */
public interface LoginService {
    public HTTPResult login(Account account);
}
