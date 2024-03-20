package com.tinklebi.sdsb.business.playerheartrate.entity.po;

import com.tinklebi.sdsb.business.playerheartrate.entity.vo.PlayerHeartRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/3/20 11:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerHeartRateData {
    private static final long serialVersionUID = -4688282826116547256L;

    private int plId;
    private PlayerHeartRateDb playerHeartRateDb;
    private List<PlayerHeartRate> heartRateList;
}
