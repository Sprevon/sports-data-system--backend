package com.tinklebi.sdsb.business.coach.dao;

import com.tinklebi.sdsb.business.coach.entity.po.CoachDb;
import com.tinklebi.sdsb.business.coach.entity.vo.Coach;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Comments 合同管理系统数据库映射
 * @Author LeonBwChen
 * @Date 2023/10/16 15:17
 */
@Mapper
public interface CoachMapper {
    /**
     * 查询教练
     * @param coachCondition
     * @return
     */
    List<Coach> selectCoach(Coach coachCondition);

    /**
     * 根据Id查询教练
     * @param coach
     * @return
     */
    Coach selectById(CoachDb coach);

    /**
     * 插入教练信息
     * @param coachInfo
     */
    void insertCoach(CoachDb coachInfo);

    /**
     * 删除教练
     * @param coachInfo
     */
    void deleteCoach(Coach coachInfo);

    /**
     * 删除教练
     * @param coachInfo
     */
    void updateCoach(CoachDb coachInfo);
}
