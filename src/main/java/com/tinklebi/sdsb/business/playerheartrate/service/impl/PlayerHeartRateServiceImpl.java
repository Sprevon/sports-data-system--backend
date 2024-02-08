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
    public HTTPResult queryPlayerHeartRates(PlayerHeartRateDb playerHeartRate) {
        List<PlayerHeartRateDb> playerHeartRateList = playerHeartRateMapper.selectPlayerHeartRates(playerHeartRate);
        if (playerHeartRateList.isEmpty()) {
            return HTTPResult.buildFault("No player heart rate information available");
        } else {
            return HTTPResult.buildSuccess(playerHeartRateList);
        }
    }

    @Override
    public HTTPResult queryPlayerHeartRateDetail(PlayerHeartRateDb playerHeartRate) {
        List<PlayerHeartRate> dbPlayerHeartRate = playerHeartRateMapper.selectById(playerHeartRate);
        if (dbPlayerHeartRate == null) {
            return HTTPResult.buildFault("Player heart rate information does not exist");
        } else {
            return HTTPResult.buildSuccess(dbPlayerHeartRate);
        }
    }

}

