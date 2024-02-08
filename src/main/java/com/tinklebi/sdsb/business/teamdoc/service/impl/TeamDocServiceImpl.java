package com.tinklebi.sdsb.business.teamdoc.service.impl;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:04
 */
import com.tinklebi.sdsb.business.teamdoc.dao.TeamDocMapper;
import com.tinklebi.sdsb.business.teamdoc.entity.po.TeamDocDb;
import com.tinklebi.sdsb.business.teamdoc.entity.vo.TeamDoc;
import com.tinklebi.sdsb.business.teamdoc.service.TeamDocService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TeamDocServiceImpl implements TeamDocService {

    @Autowired
    private TeamDocMapper teamDocMapper;

    @Override
    public HTTPResult queryTeamDocs(TeamDoc teamDoc) {
        List<TeamDoc> teamDocList = teamDocMapper.selectTeamDocs(teamDoc);
        if (teamDocList.isEmpty()) {
            return HTTPResult.buildFault("No team doctor information available");
        } else {
            return HTTPResult.buildSuccess(teamDocList);
        }
    }

    @Override
    public HTTPResult addTeamDoc(TeamDocDb teamDocDb) {
        TeamDoc dbTeamDoc = teamDocMapper.selectById(teamDocDb);
        if (dbTeamDoc == null) {
            teamDocMapper.insertTeamDoc(teamDocDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Team doctor already exists");
        }
    }

    @Override
    public HTTPResult deleteTeamDoc(TeamDocDb teamDocDb) {
        TeamDoc dbTeamDoc = teamDocMapper.selectById(teamDocDb);
        if (dbTeamDoc != null) {
            teamDocMapper.deleteTeamDoc(teamDocDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Team doctor does not exist");
        }
    }

    @Override
    public HTTPResult updateTeamDoc(TeamDocDb teamDocDb) {
        TeamDoc dbTeamDoc = teamDocMapper.selectById(teamDocDb);
        if (dbTeamDoc != null) {
            teamDocMapper.updateTeamDoc(teamDocDb);
            return HTTPResult.buildSuccess();
        } else {
            return HTTPResult.buildFault("Team doctor does not exist");
        }
    }
}
