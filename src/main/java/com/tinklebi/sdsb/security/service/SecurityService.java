package com.tinklebi.sdsb.security.service;

import com.tinklebi.sdsb.security.dao.SecurityMapper;
import com.tinklebi.sdsb.security.entity.MyAuthority;
import com.tinklebi.sdsb.security.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/8 10:14
 */
@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    private SecurityMapper securityMapper;

    /**
     * 从数据库获取用户信息
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = securityMapper.findUserByName(username);
        if (myUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Collection < ? extends GrantedAuthority> roles = myUser.getAuthorities();
        for (GrantedAuthority myAuthority : roles){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(myAuthority.getAuthority());
            grantedAuthorities.add(grantedAuthority);
        }
        User su = new User(myUser.getUsername(), myUser.getPassword(), grantedAuthorities);
        return su;
    }
}
