package com.tinklebi.sdsb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinklebi.sdsb.security.encoder.PlainPasswordEncoder;
import com.tinklebi.sdsb.security.filter.SimpleAuthenticationFilter;
import com.tinklebi.sdsb.security.filter.LoginFilter;
import com.tinklebi.sdsb.security.filter.UrlAccessDecisionManager;
import com.tinklebi.sdsb.security.filter.UrlFilterInvocationSecurityMetadataSource;
import com.tinklebi.sdsb.security.handler.AuthenticationAccessDeniedHandler;
import com.tinklebi.sdsb.security.handler.FailureHandler;
import com.tinklebi.sdsb.security.handler.SuccessHandler;
import com.tinklebi.sdsb.security.service.SecurityService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import java.io.PrintWriter;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/8 10:04
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//访问接口需要权限
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityService securityService;
    @Autowired
    private SuccessHandler successHandler;
    @Autowired
    private FailureHandler failureHandler;
    @Autowired
    UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    //密码加密
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PlainPasswordEncoder();
    }

    //登录过滤器
    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationSuccessHandler(((request, response, authentication) -> {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            org.springframework.security.core.userdetails.User sysUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            String s = new ObjectMapper().writeValueAsString(HTTPResult.buildSuccess(sysUser.getUsername() + "安全校验成功"));
            out.write(s);
            out.flush();
            out.close();
        }));
        loginFilter.setAuthenticationFailureHandler((request, response, exception) -> {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            HTTPResult r;
            if (exception instanceof LockedException) {
                r = HTTPResult.buildFault("账户被锁定，请联系管理员!");
            } else if (exception instanceof CredentialsExpiredException) {
                r = HTTPResult.buildFault("密码过期，请联系管理员!");
            } else if (exception instanceof AccountExpiredException) {
                r = HTTPResult.buildFault("账户过期，请联系管理员!");
            } else if (exception instanceof DisabledException) {
                r = HTTPResult.buildFault("账户被禁用，请联系管理员!");
            } else if (exception instanceof BadCredentialsException) {
                r = HTTPResult.buildFault("用户名或者密码输入错误，请重新输入!");
            }else{
                r = HTTPResult.buildFault(exception.getMessage());
            }
            out.write(new ObjectMapper().writeValueAsString(r));
            out.flush();
            out.close();
        });
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/sdsb/login");
        return loginFilter;
    }

    /**
     * 用户认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(passwordEncoder());
    }

    /**
     * 请求授权
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //自定义拦截器
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource); //定义安全元数据
                        object.setAccessDecisionManager(urlAccessDecisionManager); //设置决策管理器
                        return object;
                    }
                })
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/sdsb/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter pw = response.getWriter();
                    pw.write(new ObjectMapper().writeValueAsString(HTTPResult.buildSuccess("注销成功")));
                    pw.flush();
                    pw.close();
                }))
                .and()
                .cors().and().csrf().disable().exceptionHandling()
                //没有认证时，在这里处理结果，不要重定向
                .authenticationEntryPoint(((request, response, authException) -> {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(401);
                    PrintWriter pw = response.getWriter();
                    pw.write(new ObjectMapper().writeValueAsString(HTTPResult.buildInvalid()));
                    pw.flush();
                    pw.close();
                }));
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new SimpleAuthenticationFilter(securityService), UsernamePasswordAuthenticationFilter.class);
    }


}
