package com.tinklebi.sdsb.business.player.dao;

import com.tinklebi.sdsb.business.player.entity.po.PlayerDb;
import com.tinklebi.sdsb.business.player.entity.vo.Player;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:44
 */
@Mapper
public interface PlayerMapper {
    List<Player> selectPlayers(Player playerCondition);

    Player selectById(PlayerDb playerDb);

    void insertPlayer(PlayerDb playerDb);

    void deletePlayer(Player player);

    void updatePlayer(PlayerDb playerDb);
}
