package com.tinklebi.sdsb.business.coach.entity.po;

import com.tinklebi.sdsb.business.coach.entity.vo.Coach;
import lombok.*;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 12:03
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoachDb extends Coach {
    private static final long serialVersionUID = -3678031926025564223L;
    private String operatorId;
    public CoachDb(Coach coach, String operatorId){
        this.setCId(coach.getCId());
        this.setCName(coach.getCName());
        this.setCNation(coach.getCNation());
        this.setOperatorId(operatorId);
    };
}
