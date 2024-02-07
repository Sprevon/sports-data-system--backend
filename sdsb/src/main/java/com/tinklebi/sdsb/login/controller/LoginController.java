package com.tinklebi.sdsb.login.controller;

import com.tinklebi.sdsb.login.entity.vo.Account;
import com.tinklebi.sdsb.login.service.AccountService;
import com.tinklebi.sdsb.login.service.LoginService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 21:03
 */
@RestController
@RequestMapping("/sdsb")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    @ResponseBody
    public HTTPResult login(@RequestBody Account account) {
        return loginService.login(account);
    }

}














