package com.tinklebi.sdsb.business.player.controller;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:51
 */
import com.tinklebi.sdsb.business.player.entity.po.PlayerDb;
import com.tinklebi.sdsb.business.player.entity.vo.Player;
import com.tinklebi.sdsb.business.player.service.PlayerService;
import com.tinklebi.sdsb.utils.HTTPResult;
import com.tinklebi.sdsb.utils.LocalSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdsb/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping(value = "/queryPlayers")
    @ResponseBody
    public HTTPResult queryPlayers(@RequestBody Player player) {
        return playerService.queryPlayers(player);
    }

    @PostMapping(value = "/addPlayer")
    @ResponseBody
    public HTTPResult addPlayer(@RequestBody Player player) {
        PlayerDb playerDb = new PlayerDb(player, LocalSessionUtils.getOperatorId());
        return playerService.addPlayer(playerDb);
    }

    @PostMapping(value = "/deletePlayer")
    @ResponseBody
    public HTTPResult deletePlayer(@RequestBody Player player) {
        PlayerDb playerDb = new PlayerDb(player, LocalSessionUtils.getOperatorId());
        return playerService.deletePlayer(playerDb);
    }

    @PostMapping(value = "/updatePlayer")
    @ResponseBody
    public HTTPResult updatePlayer(@RequestBody Player player) {
        PlayerDb playerDb = new PlayerDb(player, LocalSessionUtils.getOperatorId());
        return playerService.updatePlayer(playerDb);
    }
}
