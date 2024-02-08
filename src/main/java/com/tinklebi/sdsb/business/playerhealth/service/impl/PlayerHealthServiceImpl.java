package com.tinklebi.sdsb.business.playerhealth.service.impl;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:31
 */
import com.tinklebi.sdsb.business.playerhealth.dao.PlayerHealthMapper;
import com.tinklebi.sdsb.business.playerhealth.entity.po.PlayerHealthDb;
import com.tinklebi.sdsb.business.playerhealth.entity.vo.PlayerHealth;
import com.tinklebi.sdsb.business.playerhealth.service.PlayerHealthService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PlayerHealthServiceImpl implements PlayerHealthService {

    @Autowired
    private PlayerHealthMapper playerHealthMapper;

    @Override
    public HTTPResult queryPlayerHealths(PlayerHealth playerHealth) {
        List<PlayerHealth> playerHealthList = playerHealthMapper.selectPlayerHealths(playerHealth);
        if (playerHealthList.isEmpty()) {
            return HTTPResult.buildFault("No player health information available");
        } else {
            return HTTPResult.buildSuccess(playerHealthList);
        }
    }

    @Override
    public HTTPResult addPlayerHealth(PlayerHealthDb playerHealthDb) {
        PlayerHealth dbPlayerHealth = playerHealthMapper.selectById(playerHealthDb);
        if (dbPlayerHealth == null) {
            playerHealthMapper.insertPlayerHealth(playerHealthDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Player health information already exists");
        }
    }

    @Override
    public HTTPResult deletePlayerHealth(PlayerHealthDb playerHealthDb) {
        PlayerHealth dbPlayerHealth = playerHealthMapper.selectById(playerHealthDb);
        if (dbPlayerHealth != null) {
            playerHealthMapper.deletePlayerHealth(playerHealthDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Player health information does not exist");
        }
    }

    @Override
    public HTTPResult updatePlayerHealth(PlayerHealthDb playerHealthDb) {
        PlayerHealth dbPlayerHealth = playerHealthMapper.selectById(playerHealthDb);
        if (dbPlayerHealth != null) {
            playerHealthMapper.updatePlayerHealth(playerHealthDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Player health information does not exist");
        }
    }
}
