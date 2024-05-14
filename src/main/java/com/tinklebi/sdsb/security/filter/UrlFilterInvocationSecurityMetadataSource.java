package com.tinklebi.sdsb.security.filter;

import com.tinklebi.sdsb.security.dao.SecurityMapper;
import com.tinklebi.sdsb.security.entity.MyAuthority;
import com.tinklebi.sdsb.security.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @Comments 核心权限校验
 * @Author LeonBwChen
 * @Date 2024/5/11 18:34
 */
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private SecurityMapper securityMapper;

    AntPathMatcher antPathMatcher =  new AntPathMatcher();

    /**
     * 用于确认路径所需权限
     * @param object the object being secured
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String url = ((FilterInvocation ) object).getRequestUrl();
        if("/sdsb/login".equals(url)){
            return null;
        }
        return SecurityConfig.createList("ROLE");
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
