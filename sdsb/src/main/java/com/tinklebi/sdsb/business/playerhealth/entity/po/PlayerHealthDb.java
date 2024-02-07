package com.tinklebi.sdsb.business.playerhealth.entity.po;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:31
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tinklebi.sdsb.business.playerhealth.entity.vo.PlayerHealth;
import lombok.Data;

@Data
public class PlayerHealthDb extends PlayerHealth {

    private static final long serialVersionUID = -7955234954778945581L;
    /**
     * 操作人编号
     */
    @JsonProperty("operatorId")
    private String operatorId;

    public PlayerHealthDb(PlayerHealth playerHealth, String operatorId) {
        super(playerHealth.getPlId(), playerHealth.getPlHeight(), playerHealth.getPlWeight(),
                playerHealth.getPlMaxHeartRate(), playerHealth.getPlMinHeartRate(),
                playerHealth.getPlAvgHeartRate(), playerHealth.getPlTotalDistance(),
                playerHealth.getPlSprint());
        this.operatorId = operatorId;
    }
}
