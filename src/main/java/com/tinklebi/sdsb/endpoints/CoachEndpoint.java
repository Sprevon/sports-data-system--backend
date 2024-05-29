package com.tinklebi.sdsb.endpoints;

import com.tinklebi.sdsb.business.coach.entity.vo.Coach;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/29 10:04
 */
@Component
@Endpoint(id = "coach-point")
public class CoachEndpoint {
    @ReadOperation
    public Coach getCoach(@Selector String cId){
        return new Coach("Get Coach", "Get Nation", cId);
    }

    @WriteOperation
    public Coach postCoach(){
        return new Coach("Post Coach", "Post Nation", "Post Id");
    }
}
