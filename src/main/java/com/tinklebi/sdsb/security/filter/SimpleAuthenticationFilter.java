package com.tinklebi.sdsb.security.filter;

import com.tinklebi.sdsb.security.service.SecurityService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/14 19:02
 */
@Component
public class SimpleAuthenticationFilter extends OncePerRequestFilter {
    private final SecurityService service;

    public SimpleAuthenticationFilter(SecurityService service) {
        this.service = service;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        if (username != null && password != null){
            UserDetails user = service.loadUserByUsername(username);
            if (user != null && password.equals(user.getPassword())){
                Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
