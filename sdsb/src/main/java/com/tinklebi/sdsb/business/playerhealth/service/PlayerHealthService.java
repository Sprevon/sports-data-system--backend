package com.tinklebi.sdsb.business.playerhealth.service;

import com.tinklebi.sdsb.business.playerhealth.entity.po.PlayerHealthDb;
import com.tinklebi.sdsb.business.playerhealth.entity.vo.PlayerHealth;
import com.tinklebi.sdsb.utils.HTTPResult;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:31
 */
public interface PlayerHealthService {
    HTTPResult queryPlayerHealths(PlayerHealth playerHealth);

    HTTPResult addPlayerHealth(PlayerHealthDb playerHealthDb);

    HTTPResult deletePlayerHealth(PlayerHealthDb playerHealthDb);

    HTTPResult updatePlayerHealth(PlayerHealthDb playerHealthDb);
}
