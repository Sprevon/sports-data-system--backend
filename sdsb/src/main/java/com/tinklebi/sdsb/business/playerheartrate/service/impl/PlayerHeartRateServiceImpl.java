package com.tinklebi.sdsb.business.playerheartrate.service.impl;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:39
 */
import com.tinklebi.sdsb.business.playerheartrate.dao.PlayerHeartRateMapper;
import com.tinklebi.sdsb.business.playerheartrate.entity.po.PlayerHeartRateDb;
import com.tinklebi.sdsb.business.playerheartrate.entity.vo.PlayerHeartRate;
import com.tinklebi.sdsb.business.playerheartrate.service.PlayerHeartRateService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PlayerHeartRateServiceImpl implements PlayerHeartRateService {

    @Autowired
    private PlayerHeartRateMapper playerHeartRateMapper;

    @Override
    public HTTPResult queryPlayerHeartRates(PlayerHeartRate playerHeartRate) {
        List<PlayerHeartRate> playerHeartRateList = playerHeartRateMapper.selectPlayerHeartRates(playerHeartRate);
        if (playerHeartRateList.isEmpty()) {
            return HTTPResult.buildFault("No player heart rate information available");
        } else {
            return HTTPResult.buildSuccess(playerHeartRateList);
        }
    }

    @Override
    public HTTPResult addPlayerHeartRate(PlayerHeartRateDb playerHeartRateDb) {
        PlayerHeartRate dbPlayerHeartRate = playerHeartRateMapper.selectById(playerHeartRateDb);
        if (dbPlayerHeartRate == null) {
            playerHeartRateMapper.insertPlayerHeartRate(playerHeartRateDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Player heart rate information already exists");
        }
    }

    @Override
    public HTTPResult deletePlayerHeartRate(PlayerHeartRateDb playerHeartRateDb) {
        PlayerHeartRate dbPlayerHeartRate = playerHeartRateMapper.selectById(playerHeartRateDb);
        if (dbPlayerHeartRate != null) {
            playerHeartRateMapper.deletePlayerHeartRate(playerHeartRateDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Player heart rate information does not exist");
        }
    }

    @Override
    public HTTPResult updatePlayerHeartRate(PlayerHeartRateDb playerHeartRateDb) {
        PlayerHeartRate dbPlayerHeartRate = playerHeartRateMapper.selectById(playerHeartRateDb);
        if (dbPlayerHeartRate != null) {
            playerHeartRateMapper.updatePlayerHeartRate(playerHeartRateDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Player heart rate information does not exist");
        }
    }
}

