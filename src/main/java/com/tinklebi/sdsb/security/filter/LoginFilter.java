package com.tinklebi.sdsb.security.filter;


import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Comments 核心登录
 * @Author LeonBwChen
 * @Date 2024/5/11 18:50
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //方法判别
        if(!"POST".equals(request.getMethod())){
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod()
            );
        }

        //session验证
        HttpSession session = request.getSession();
        String verifyCode = (String) session.getAttribute("verify_code");
        System.out.println("verifyCode---->" + verifyCode );

        //类型验证
        logger.error("request.getContextType()--->" + request.getContentType());
        logger.error("类型比较:" + "application/json;charset=utf-8".equalsIgnoreCase(request.getContentType()));
        if ("application/json;charset=utf-8".equalsIgnoreCase(request.getContentType()) || "application/json".equals(request.getContentType())){
            Map<String, String> loginData = new HashMap<>();
            try{
                loginData = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            } catch (Exception ignored) {
            }finally {
                String code = loginData.get("code");
                System.out.println("code--->" + code);
            }
            String username = loginData.get(getUsernameParameter());
            String password = loginData.get(getPasswordParameter());
            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            username = username.trim();
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            setDetails(request, authenticationToken);
            return this.getAuthenticationManager().authenticate(authenticationToken);
        }else {
            return super.attemptAuthentication(request, response);
        }
    }

}
