package com.tinklebi.sdsb.business.playerheartrate.service;

import com.tinklebi.sdsb.business.playerheartrate.entity.po.PlayerHeartRateDb;
import com.tinklebi.sdsb.business.playerheartrate.entity.vo.PlayerHeartRate;
import com.tinklebi.sdsb.utils.HTTPResult;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:39
 */
public interface PlayerHeartRateService {
    HTTPResult queryPlayerHeartRates(PlayerHeartRate playerHeartRate);

    HTTPResult addPlayerHeartRate(PlayerHeartRateDb playerHeartRateDb);

    HTTPResult deletePlayerHeartRate(PlayerHeartRateDb playerHeartRateDb);

    HTTPResult updatePlayerHeartRate(PlayerHeartRateDb playerHeartRateDb);
}
