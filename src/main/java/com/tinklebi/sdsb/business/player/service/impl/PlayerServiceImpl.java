package com.tinklebi.sdsb.business.player.service.impl;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:46
 */
import com.tinklebi.sdsb.business.device.dao.DeviceMapper;
import com.tinklebi.sdsb.business.device.entity.po.DeviceDb;
import com.tinklebi.sdsb.business.device.entity.vo.Device;
import com.tinklebi.sdsb.business.player.dao.PlayerMapper;
import com.tinklebi.sdsb.business.player.entity.po.PlayerDb;
import com.tinklebi.sdsb.business.player.entity.vo.Player;
import com.tinklebi.sdsb.business.player.service.PlayerService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private DeviceMapper deviceMapper;

    private boolean isDeviceExist(String deviceId){
        DeviceDb testDevice = new DeviceDb();
        testDevice.setDeviceId(deviceId);
        Device device = deviceMapper.selectById(testDevice);
        return device != null;
    }

    @Override
    public HTTPResult queryPlayers(Player player) {
        List<Player> playerList = playerMapper.selectPlayers(player);
        if (playerList.isEmpty()) {
            return HTTPResult.buildFault("暂无运动员信息");
        } else {
            return HTTPResult.buildSuccess(playerList);
        }
    }

    @Override
    public HTTPResult addPlayer(PlayerDb playerDb) {
        Player dbPlayer = playerMapper.selectById(playerDb);
        if (dbPlayer == null) {
            if (isDeviceExist(Long.toString(playerDb.getPlDeviceId()))){
                playerMapper.insertPlayer(playerDb);
                return HTTPResult.buildSuccess();
            }else {
                return HTTPResult.buildFault("设备不存在");
            }
        } else {
            return HTTPResult.buildFault("运动员已存在");
        }
    }

    @Override
    public HTTPResult deletePlayer(PlayerDb playerDb) {
        Player dbPlayer = playerMapper.selectById(playerDb);
        if (dbPlayer != null) {
            playerMapper.deletePlayer(playerDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("运动员不存在");
        }
    }

    @Override
    public HTTPResult updatePlayer(PlayerDb playerDb) {
        Player dbPlayer = playerMapper.selectById(playerDb);
        if (dbPlayer != null) {
            if (isDeviceExist(Long.toString(playerDb.getPlDeviceId()))){
                playerMapper.updatePlayer(playerDb);
                return HTTPResult.buildSuccess();
            }else {
                return HTTPResult.buildFault("设备不存在");
            }
        } else {
            return HTTPResult.buildFault("运动员不存在");
        }
    }
}
