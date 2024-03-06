package com.tinklebi.sdsb;

import com.tinklebi.sdsb.business.coach.controller.CoachController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SdsbApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testAspect(){
        System.out.println("========================================================");
        CoachController c1 = (CoachController) applicationContext.getBean("coachController");
        System.out.println(c1);
        CoachController c2 = (CoachController) applicationContext.getBean(CoachController.class);
        System.out.println(c2);
        System.out.println(c1 == c2);
        c1.testCoach();
        System.out.println("========================================================");
    }

}
