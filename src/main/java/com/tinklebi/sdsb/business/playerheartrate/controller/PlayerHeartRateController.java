package com.tinklebi.sdsb.business.playerheartrate.controller;

import com.tinklebi.sdsb.business.playerheartrate.entity.po.PlayerHeartRateDb;
import com.tinklebi.sdsb.business.playerheartrate.entity.vo.PlayerHeartRate;
import com.tinklebi.sdsb.business.playerheartrate.service.PlayerHeartRateService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:38
 */
@RestController
@RequestMapping("/sdsb/playerheartrate")
public class PlayerHeartRateController {
    @Autowired
    private PlayerHeartRateService playerHeartRateService;

    @PostMapping(value = "/queryPlayerHeartRates")
    @ResponseBody
    public HTTPResult queryPlayerHeartRates(@RequestBody PlayerHeartRateDb playerHeartRate) {
        return playerHeartRateService.queryPlayerHeartRates(playerHeartRate);
    }

    @PostMapping(value = "/queryPlayerHeartRateDetail")
    @ResponseBody
    public HTTPResult queryPlayerHeartRateDetail(@RequestBody PlayerHeartRateDb playerHeartRate) {
        return playerHeartRateService.queryPlayerHeartRateDetail(playerHeartRate);
    }

}
