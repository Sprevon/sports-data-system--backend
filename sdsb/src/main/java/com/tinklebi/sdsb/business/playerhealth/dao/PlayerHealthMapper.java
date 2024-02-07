package com.tinklebi.sdsb.business.playerhealth.dao;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:31
 */
import com.tinklebi.sdsb.business.playerhealth.entity.po.PlayerHealthDb;
import com.tinklebi.sdsb.business.playerhealth.entity.vo.PlayerHealth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayerHealthMapper {
    List<PlayerHealth> selectPlayerHealths(PlayerHealth playerHealthCondition);

    PlayerHealth selectById(PlayerHealthDb playerHealthDb);

    void insertPlayerHealth(PlayerHealthDb playerHealthDb);

    void deletePlayerHealth(PlayerHealth playerHealth);

    void updatePlayerHealth(PlayerHealthDb playerHealthDb);
}

