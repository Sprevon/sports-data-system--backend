package com.tinklebi.sdsb.business.teamdoc.dao;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:02
 */
import com.tinklebi.sdsb.business.teamdoc.entity.po.TeamDocDb;
import com.tinklebi.sdsb.business.teamdoc.entity.vo.TeamDoc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamDocMapper {
    List<TeamDoc> selectTeamDocs(TeamDoc teamDocCondition);

    TeamDoc selectById(TeamDocDb teamDocDb);

    void insertTeamDoc(TeamDocDb teamDocDb);

    void deleteTeamDoc(TeamDoc teamDoc);

    void updateTeamDoc(TeamDocDb teamDocDb);
}
