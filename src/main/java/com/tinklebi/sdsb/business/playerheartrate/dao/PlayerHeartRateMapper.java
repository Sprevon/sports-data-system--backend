package com.tinklebi.sdsb.business.playerheartrate.dao;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:38
 */
import com.tinklebi.sdsb.business.playerheartrate.entity.po.PlayerHeartRateData;
import com.tinklebi.sdsb.business.playerheartrate.entity.po.PlayerHeartRateDb;
import com.tinklebi.sdsb.business.playerheartrate.entity.vo.PlayerHeartRate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayerHeartRateMapper {
    List<PlayerHeartRateDb> selectPlayerHeartRates(PlayerHeartRateDb playerHeartRateCondition);

    List<PlayerHeartRate> selectById(PlayerHeartRateDb playerHeartRateDb);

    void insertPlayerHeartRate(PlayerHeartRateDb playerHeartRateDb);

    void deletePlayerHeartRate(PlayerHeartRate playerHeartRate);

    void updatePlayerHeartRate(PlayerHeartRateDb playerHeartRateDb);

    PlayerHeartRateData selectPlayerData(PlayerHeartRateDb playerHeartRateDb);
}
