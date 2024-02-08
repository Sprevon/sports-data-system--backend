package com.tinklebi.sdsb.login.service;

import com.tinklebi.sdsb.login.entity.po.AccountDb;
import com.tinklebi.sdsb.login.entity.vo.Account;
import com.tinklebi.sdsb.utils.HTTPResult;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:59
 */
public interface AccountService {
    HTTPResult queryAccounts(Account account);

    HTTPResult addAccount(AccountDb accountDb);

    HTTPResult deleteAccount(AccountDb accountDb);

    HTTPResult updateAccount(AccountDb accountDb);
}
