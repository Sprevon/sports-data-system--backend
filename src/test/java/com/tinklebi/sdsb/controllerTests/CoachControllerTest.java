package com.tinklebi.sdsb.controllerTests;

import com.tinklebi.sdsb.business.coach.controller.CoachController;
import com.tinklebi.sdsb.business.coach.entity.vo.Coach;
import com.tinklebi.sdsb.business.coach.service.CoachService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 使用SpringBootTest注解，启动一个随机端口的真实HTTP服务器
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableConfigurationProperties(Coach.class)
@Slf4j
public class CoachControllerTest {

    // 自动注入TestRestTemplate，用于发送HTTP请求

    @Autowired
    private MockMvc mockMvc;


    // 测试方法，测试带参数的testCoach方法
    @Test
    public void testCoach_withParams1() throws Exception {
        Coach coach = new Coach();
        coach.setCName("Test Coach");

        mockMvc.perform(MockMvcRequestBuilders.post("/sdsb/coach/testCoach")
                        .param("number", "1")
                        .flashAttr("coach", coach))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Test Coach测试成功1"));
    }

    @Autowired
    private Coach coach;

    @Test
    public void testCoachProperties(){
        Assertions.assertEquals(coach.getCName(), "Shelton");
        Assertions.assertEquals(coach.getCNation(), "America");
        Assertions.assertEquals(coach.getCId(), "1");
    }

    @Test
    public void testDeviceController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/sdsb/device/test"))
                .andExpect(status().isOk());
    }
}