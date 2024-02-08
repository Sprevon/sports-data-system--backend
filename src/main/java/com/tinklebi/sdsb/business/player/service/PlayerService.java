package com.tinklebi.sdsb.business.player.service;

import com.tinklebi.sdsb.business.player.entity.po.PlayerDb;
import com.tinklebi.sdsb.business.player.entity.vo.Player;
import com.tinklebi.sdsb.utils.HTTPResult;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:45
 */
public interface PlayerService {
    HTTPResult queryPlayers(Player player);

    HTTPResult addPlayer(PlayerDb playerDb);

    HTTPResult deletePlayer(PlayerDb playerDb);

    HTTPResult updatePlayer(PlayerDb playerDb);
}
