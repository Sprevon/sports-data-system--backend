package com.tinklebi.sdsb.login.controller;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:58
 */
import com.tinklebi.sdsb.login.entity.po.AccountDb;
import com.tinklebi.sdsb.login.entity.vo.Account;
import com.tinklebi.sdsb.login.service.AccountService;
import com.tinklebi.sdsb.utils.HTTPResult;
import com.tinklebi.sdsb.utils.LocalSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdsb/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/queryAccounts")
    @ResponseBody
    public HTTPResult queryAccounts(@RequestBody Account account) {
        return accountService.queryAccounts(account);
    }

    @PostMapping(value = "/addAccount")
    @ResponseBody
    public HTTPResult addAccount(@RequestBody Account account) {
        AccountDb accountDb = new AccountDb(account, LocalSessionUtils.getOperatorId());
        return accountService.addAccount(accountDb);
    }

    @PostMapping(value = "/deleteAccount")
    @ResponseBody
    public HTTPResult deleteAccount(@RequestBody Account account) {
        AccountDb accountDb = new AccountDb(account, LocalSessionUtils.getOperatorId());
        return accountService.deleteAccount(accountDb);
    }

    @PostMapping(value = "/updateAccount")
    @ResponseBody
    public HTTPResult updateAccount(@RequestBody Account account) {
        AccountDb accountDb = new AccountDb(account, LocalSessionUtils.getOperatorId());
        return accountService.updateAccount(accountDb);
    }
}
