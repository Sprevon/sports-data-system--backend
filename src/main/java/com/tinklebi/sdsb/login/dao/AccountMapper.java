package com.tinklebi.sdsb.login.dao;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:58
 */
import com.tinklebi.sdsb.login.entity.po.AccountDb;
import com.tinklebi.sdsb.login.entity.vo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    List<Account> selectAccounts(Account accountCondition);

    Account selectById(AccountDb accountDb);

    void insertAccount(AccountDb accountDb);

    void deleteAccount(Account account);

    void updateAccount(AccountDb accountDb);
}
