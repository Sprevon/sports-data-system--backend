package com.tinklebi.sdsb.business.propertyman.entity.po;

import com.tinklebi.sdsb.business.propertyman.entity.vo.PropertyMan;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 19:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PropertyManDb extends PropertyMan {
    private static final long serialVersionUID = -1242056342030828800L;
    private String operatorId;
    public PropertyManDb(PropertyMan propertyMan, String operatorId){
        super(
                propertyMan.getPropId(),
                propertyMan.getPropName(),
                propertyMan.getPropState(),
                propertyMan.getPropRoomId()
        );
        this.operatorId = operatorId;
    }
}
