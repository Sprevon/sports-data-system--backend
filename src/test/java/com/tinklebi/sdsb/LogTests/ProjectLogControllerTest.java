package com.tinklebi.sdsb.LogTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/4/3 10:28
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProjectLogControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRoot() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/root/test"))
                .andExpect(MockMvcResultMatchers.content().string("root test"));
    }

}
