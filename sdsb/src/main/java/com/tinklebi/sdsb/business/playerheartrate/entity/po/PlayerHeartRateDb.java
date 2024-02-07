package com.tinklebi.sdsb.business.playerheartrate.entity.po;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:39
 */
import com.tinklebi.sdsb.business.playerheartrate.entity.vo.PlayerHeartRate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlayerHeartRateDb extends PlayerHeartRate {

    private static final long serialVersionUID = 957877721186164657L;
    /**
     * 操作人编号
     */
    private String operatorId;

    public PlayerHeartRateDb(PlayerHeartRate playerHeartRate, String operatorId) {
        super(playerHeartRate.getPlId(), playerHeartRate.getPlCurrentHeartRate(), playerHeartRate.getCreateDate());
        this.operatorId = operatorId;
    }
}
