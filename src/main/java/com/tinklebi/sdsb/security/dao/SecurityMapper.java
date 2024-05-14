package com.tinklebi.sdsb.security.dao;

import com.tinklebi.sdsb.security.entity.MyAuthority;
import com.tinklebi.sdsb.security.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/8 10:37
 */
@Mapper
public interface SecurityMapper {
    /**
     * 查找用户及权限
     * @param username
     * @return
     */
    MyUser findUserByName(String username);

    List<MyAuthority> findAllByMyAuthorities();
}
