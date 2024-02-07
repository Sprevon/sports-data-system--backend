package com.tinklebi.sdsb.business.player.entity.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tinklebi.sdsb.business.player.entity.vo.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDb extends Player implements Serializable {

    private static final long serialVersionUID = -103798309381481632L;
    /**
     * 操作人编号
     */
    @JsonProperty("operatorId")
    private String operatorId;

    public PlayerDb(Player player, String operatorId) {
        super(player.getPlId(), player.getPlName(), player.getPlNation(),
                player.getPlState(), player.getPlField(), player.getPlPosition(),
                player.getPlDeviceId());
        this.operatorId = operatorId;
    }
}
