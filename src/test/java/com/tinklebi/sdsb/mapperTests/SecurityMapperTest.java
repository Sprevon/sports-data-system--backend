package com.tinklebi.sdsb.mapperTests;

import com.tinklebi.sdsb.security.dao.SecurityMapper;
import com.tinklebi.sdsb.security.entity.MyUser;
import com.tinklebi.sdsb.security.service.SecurityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/8 11:28
 */
@SpringBootTest
public class SecurityMapperTest {
    @Autowired
    SecurityMapper securityMapper;
    @Autowired
    SecurityService securityService;

    @Test
    void testSecurityMapper(){
        MyUser myUser = securityMapper.findUserByName("admin");
        System.out.println(myUser);
    }

    @Test
    void testSecurityService(){
        UserDetails user = securityService.loadUserByUsername("admin");
        System.out.println(user);
    }
}
