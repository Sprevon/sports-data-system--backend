package com.tinklebi.sdsb.business.coach.service;


import com.tinklebi.sdsb.business.coach.entity.po.CoachDb;
import com.tinklebi.sdsb.business.coach.entity.vo.Coach;
import com.tinklebi.sdsb.utils.HTTPResult;

/**
 * @Comments 合同管理系统Service
 * @Author LeonBwChen
 * @Date 2023/10/16 15:22
 */
public interface CoachService {
    /**
     * 查询教练
     * @param coach
     * @return
     */
    HTTPResult queryCoach(Coach coach);

    /**
     * 新增教练
     * @param coach
     */
    HTTPResult addCoach(CoachDb coach);

    /**
     * 删除教练
     * @param coach
     */
    HTTPResult deleteCoach(CoachDb coach);

    /**
     * 更新教练信息
     * @param coach
     */
    HTTPResult updateCoach(CoachDb coach);
}
