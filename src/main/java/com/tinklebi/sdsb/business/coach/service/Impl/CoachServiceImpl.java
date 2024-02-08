package com.tinklebi.sdsb.business.coach.service.Impl;

import com.tinklebi.sdsb.business.coach.dao.CoachMapper;
import com.tinklebi.sdsb.business.coach.entity.po.CoachDb;
import com.tinklebi.sdsb.business.coach.entity.vo.Coach;
import com.tinklebi.sdsb.business.coach.service.CoachService;
import com.tinklebi.sdsb.utils.HTTPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Comments 合同管理系统逻辑实现
 * @Author LeonBwChen
 * @Date 2023/10/16 15:22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CoachServiceImpl implements CoachService {
    @Autowired
    private CoachMapper coachMapper;

    /**
     * 查询教练
     *
     * @param coach
     * @return
     */
    @Override
    public HTTPResult queryCoach(Coach coach) {
        List<Coach> coachList = coachMapper.selectCoach(coach);
        if (coachList.isEmpty()){
            return HTTPResult.buildFault("暂无教练信息");
        }else {
            return HTTPResult.buildSuccess(coachList);
        }
    }

    /**
     * 新增教练
     *
     * @param coachDb
     */
    @Override
    public HTTPResult addCoach(CoachDb coachDb) {
        Coach dbCoach = coachMapper.selectById(coachDb);
        if (dbCoach == null){
            coachMapper.insertCoach(coachDb);
            return HTTPResult.buildSuccess();
        }else {
            return HTTPResult.buildFault("教练已存在");
        }
    }

    /**
     * 删除教练
     *
     * @param coach
     */
    @Override
    public HTTPResult deleteCoach(CoachDb coach) {
        Coach dbCoach = coachMapper.selectById(coach);
        if (dbCoach != null){
            coachMapper.deleteCoach(coach);
            return HTTPResult.buildSuccess();
        }else {
            return HTTPResult.buildFault("教练不存在");
        }
    }

    /**
     * 更新教练信息
     *
     * @param coach
     */
    @Override
    public HTTPResult updateCoach(CoachDb coach) {
        Coach dbCoach = coachMapper.selectById(coach);
        if (dbCoach != null){
            coachMapper.updateCoach(coach);
            return HTTPResult.buildSuccess();
        }else {
            return HTTPResult.buildFault("教练不存在");
        }
    }
}
