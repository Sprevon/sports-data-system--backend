package com.tinklebi.sdsb.business.teamdoc.service;

import com.tinklebi.sdsb.business.teamdoc.entity.po.TeamDocDb;
import com.tinklebi.sdsb.business.teamdoc.entity.vo.TeamDoc;
import com.tinklebi.sdsb.utils.HTTPResult;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:03
 */
public interface TeamDocService {
    HTTPResult queryTeamDocs(TeamDoc teamDoc);

    HTTPResult addTeamDoc(TeamDocDb teamDocDb);

    HTTPResult deleteTeamDoc(TeamDocDb teamDocDb);

    HTTPResult updateTeamDoc(TeamDocDb teamDocDb);
}
