package com.tinklebi.sdsb.business.playerhealth.controller;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:32
 */
import com.tinklebi.sdsb.business.playerhealth.entity.po.PlayerHealthDb;
import com.tinklebi.sdsb.business.playerhealth.entity.vo.PlayerHealth;
import com.tinklebi.sdsb.business.playerhealth.service.PlayerHealthService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdsb/playerhealth")
public class PlayerHealthController {
    @Autowired
    private PlayerHealthService playerHealthService;

    @PostMapping(value = "/queryPlayerHealths")
    @ResponseBody
    public HTTPResult queryPlayerHealths(@RequestBody PlayerHealth playerHealth) {
        return playerHealthService.queryPlayerHealths(playerHealth);
    }

    @PostMapping(value = "/addPlayerHealth")
    @ResponseBody
    public HTTPResult addPlayerHealth(@RequestBody PlayerHealth playerHealth) {
        PlayerHealthDb playerHealthDb = new PlayerHealthDb(playerHealth, "1");
        return playerHealthService.addPlayerHealth(playerHealthDb);
    }

    @PostMapping(value = "/deletePlayerHealth")
    @ResponseBody
    public HTTPResult deletePlayerHealth(@RequestBody PlayerHealth playerHealth) {
        PlayerHealthDb playerHealthDb = new PlayerHealthDb(playerHealth, "1");
        return playerHealthService.deletePlayerHealth(playerHealthDb);
    }

    @PostMapping(value = "/updatePlayerHealth")
    @ResponseBody
    public HTTPResult updatePlayerHealth(@RequestBody PlayerHealth playerHealth) {
        PlayerHealthDb playerHealthDb = new PlayerHealthDb(playerHealth, "1");
        return playerHealthService.updatePlayerHealth(playerHealthDb);
    }
}
