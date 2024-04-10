package com.tinklebi.sdsb.controllerTests;

import com.tinklebi.sdsb.business.coach.entity.vo.Coach;
import com.tinklebi.sdsb.login.entity.vo.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/4/10 10:21
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableConfigurationProperties(Coach.class)
@Slf4j
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLogin() throws Exception {
        String json = "{\"account\": \"admin\", \"password\":\"1234\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/sdsb/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());

    }
}
