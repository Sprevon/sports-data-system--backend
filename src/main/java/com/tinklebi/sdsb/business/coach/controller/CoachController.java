package com.tinklebi.sdsb.business.coach.controller;

import com.tinklebi.sdsb.business.coach.entity.po.CoachDb;
import com.tinklebi.sdsb.business.coach.service.CoachService;
import com.tinklebi.sdsb.business.coach.entity.vo.Coach;
import com.tinklebi.sdsb.utils.HTTPResult;
import com.tinklebi.sdsb.utils.LocalSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Comments 合同管理系统对外开放接口
 * @Author LeonBwChen
 * @Date 2023/10/16 15:23
 */
@RestController
@RequestMapping("/sdsb/coach")
public class CoachController {
    @Autowired
    private CoachService service;

    @PostMapping(value = "/queryCoach")
    @ResponseBody
    public HTTPResult queryCoach(@RequestBody Coach coach){
        return service.queryCoach(coach);
    }

    @PostMapping(value = "/addCoach")
    @ResponseBody
    public HTTPResult addCoach(@RequestBody Coach coach){
        CoachDb coachDb = new CoachDb(coach, LocalSessionUtils.getOperatorId());
        return service.addCoach(coachDb);
    }
    @PostMapping(value = "/deleteCoach")
    @ResponseBody
    public HTTPResult deleteCoach(@RequestBody Coach coach){
        CoachDb coachDb = new CoachDb(coach, LocalSessionUtils.getOperatorId());
        return service.deleteCoach(coachDb);
    }
    @PostMapping(value = "/updateCoach")
    @ResponseBody
    public HTTPResult updateCoach(@RequestBody Coach coach){
        CoachDb coachDb = new CoachDb(coach, LocalSessionUtils.getOperatorId());
        return service.updateCoach(coachDb);
    }
}
