package com.tinklebi.sdsb.mapperTests;

import com.tinklebi.sdsb.business.playerheartrate.dao.PlayerHeartRateMapper;
import com.tinklebi.sdsb.business.playerheartrate.entity.po.PlayerHeartRateData;
import com.tinklebi.sdsb.business.playerheartrate.entity.po.PlayerHeartRateDb;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/3/20 11:40
 */
@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerHeartRateMapperTest {
    @Autowired
    private PlayerHeartRateMapper playerHeartRateMapper;

    @Test
    public void testSelectPlayerHeartRates(){
        PlayerHeartRateDb query = new PlayerHeartRateDb();
        List<PlayerHeartRateDb> result = playerHeartRateMapper.selectPlayerHeartRates(query);
        assertNotNull(result, "The result should not be null");
        assertFalse(result.isEmpty(), "The result should not be empty");
    }

    @Test
    public void testSelectPlayerHeartRateData(){
        PlayerHeartRateDb query = new PlayerHeartRateDb();
        query.setPlId(1L);
        PlayerHeartRateData resultData = playerHeartRateMapper.selectPlayerData(query);
        assertNotNull(resultData, "The result should not be null");
    }
}
