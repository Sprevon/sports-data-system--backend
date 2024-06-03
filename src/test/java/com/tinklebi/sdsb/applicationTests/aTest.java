package com.tinklebi.sdsb.applicationTests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/31 9:20
 */
@SpringBootTest
public class aTest {
    public int test(){
        int i = 0;
        try{
            i++;
            i = i / 0;
            return i++;
        }catch (Exception e){
            i++;
            return i++;
        }finally {
            return ++i;
        }
    }

    @Test
    public void tests(){
        System.out.println(test());
    }
}
