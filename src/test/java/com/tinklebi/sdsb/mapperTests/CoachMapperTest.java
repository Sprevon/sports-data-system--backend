package com.tinklebi.sdsb.mapperTests;

import com.tinklebi.sdsb.business.coach.dao.CoachMapper;
import com.tinklebi.sdsb.business.coach.entity.po.CoachDb;
import com.tinklebi.sdsb.business.coach.entity.vo.Coach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/3/13 10:26
 */
@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CoachMapperTest {
    @Autowired
    private CoachMapper coachMapper;

    private Coach coachCondition;
    private CoachDb coachDb;

    @BeforeEach
    void setUp() {
        coachCondition = new Coach();
        coachDb = new CoachDb();
    }

    @Test
    public void testSelectCoach() {
        List<Coach> result = coachMapper.selectCoach(coachCondition);
        assertThat(result).isNotNull();
        System.out.println(result);
    }
}
