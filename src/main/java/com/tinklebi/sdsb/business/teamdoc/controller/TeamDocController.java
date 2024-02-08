package com.tinklebi.sdsb.business.teamdoc.controller;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:04
 */
import com.tinklebi.sdsb.business.teamdoc.entity.po.TeamDocDb;
import com.tinklebi.sdsb.business.teamdoc.entity.vo.TeamDoc;
import com.tinklebi.sdsb.business.teamdoc.service.TeamDocService;
import com.tinklebi.sdsb.utils.HTTPResult;
import com.tinklebi.sdsb.utils.LocalSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdsb/teamDoc")
public class TeamDocController {
    @Autowired
    private TeamDocService teamDocService;

    @PostMapping(value = "/queryTeamDocs")
    @ResponseBody
    public HTTPResult queryTeamDocs(@RequestBody TeamDoc teamDoc) {
        return teamDocService.queryTeamDocs(teamDoc);
    }

    @PostMapping(value = "/addTeamDoc")
    @ResponseBody
    public HTTPResult addTeamDoc(@RequestBody TeamDoc teamDoc) {
        TeamDocDb teamDocDb = new TeamDocDb(teamDoc, LocalSessionUtils.getOperatorId());
        return teamDocService.addTeamDoc(teamDocDb);
    }

    @PostMapping(value = "/deleteTeamDoc")
    @ResponseBody
    public HTTPResult deleteTeamDoc(@RequestBody TeamDoc teamDoc) {
        TeamDocDb teamDocDb = new TeamDocDb(teamDoc, LocalSessionUtils.getOperatorId());
        return teamDocService.deleteTeamDoc(teamDocDb);
    }

    @PostMapping(value = "/updateTeamDoc")
    @ResponseBody
    public HTTPResult updateTeamDoc(@RequestBody TeamDoc teamDoc) {
        TeamDocDb teamDocDb = new TeamDocDb(teamDoc, LocalSessionUtils.getOperatorId());
        return teamDocService.updateTeamDoc(teamDocDb);
    }
}
