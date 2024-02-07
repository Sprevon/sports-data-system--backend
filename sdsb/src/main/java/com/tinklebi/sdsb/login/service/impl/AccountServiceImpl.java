package com.tinklebi.sdsb.login.service.impl;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:59
 */
import com.tinklebi.sdsb.login.dao.AccountMapper;
import com.tinklebi.sdsb.login.entity.po.AccountDb;
import com.tinklebi.sdsb.login.entity.vo.Account;
import com.tinklebi.sdsb.login.service.AccountService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public HTTPResult queryAccounts(Account account) {
        List<Account> accountList = accountMapper.selectAccounts(account);
        if (accountList.isEmpty()) {
            return HTTPResult.buildFault("No account information available");
        } else {
            return HTTPResult.buildSuccess(accountList);
        }
    }

    @Override
    public HTTPResult addAccount(AccountDb accountDb) {
        Account dbAccount = accountMapper.selectById(accountDb);
        if (dbAccount == null) {
            accountMapper.insertAccount(accountDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Account already exists");
        }
    }

    @Override
    public HTTPResult deleteAccount(AccountDb accountDb) {
        Account dbAccount = accountMapper.selectById(accountDb);
        if (dbAccount != null) {
            accountMapper.deleteAccount(accountDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Account does not exist");
        }
    }

    @Override
    public HTTPResult updateAccount(AccountDb accountDb) {
        Account dbAccount = accountMapper.selectById(accountDb);
        if (dbAccount != null) {
            accountMapper.updateAccount(accountDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Account does not exist");
        }
    }
}

