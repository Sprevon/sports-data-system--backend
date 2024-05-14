package com.tinklebi.sdsb.login.service.impl;

import com.tinklebi.sdsb.login.dao.AccountMapper;
import com.tinklebi.sdsb.login.entity.po.AccountDb;
import com.tinklebi.sdsb.login.entity.vo.Account;
import com.tinklebi.sdsb.login.service.LoginService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 21:06
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public HTTPResult login(Account account) {
        if (account.getUsername() == null || account.getPassword() == null){
            return HTTPResult.buildFault("登录信息不完整");
        }else {
            Account personAcc = accountMapper.selectById(new AccountDb(account, ""));
            if (personAcc == null || !Objects.equals(personAcc.getPassword(), account.getPassword())){
                return HTTPResult.buildFault("用户名或密码错误");
            }else {
                return HTTPResult.buildSuccess("登录成功！");

            }
        }
    }
}
