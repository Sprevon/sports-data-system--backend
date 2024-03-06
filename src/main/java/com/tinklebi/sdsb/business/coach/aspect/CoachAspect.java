package com.tinklebi.sdsb.business.coach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/2/28 11:23
 */
@Component
@Aspect
public class CoachAspect {
    @Before("execution(* testCoach())")
    public void beforeTestCoach(JoinPoint joinPoint){
        System.out.println("beforeTestCoach");
        System.out.println(joinPoint);
    }

    @After("execution(* testCoach())")
    public void afterTestCoach(){
        System.out.println("afterTestCoach");
    }
}
