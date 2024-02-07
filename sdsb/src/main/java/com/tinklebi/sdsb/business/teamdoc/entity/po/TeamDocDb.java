package com.tinklebi.sdsb.business.teamdoc.entity.po;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:02
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tinklebi.sdsb.business.teamdoc.entity.vo.TeamDoc;
import lombok.Data;

@Data
public class TeamDocDb extends TeamDoc {

    private static final long serialVersionUID = -8466713451878023371L;
    /**
     * 操作人编号
     */
    @JsonProperty("operatorId")
    private String operatorId;

    public TeamDocDb(TeamDoc teamDoc, String operatorId) {
        super(teamDoc.getDocId(), teamDoc.getDocName(), teamDoc.getDocMajor(),
                teamDoc.getDocPosition(), teamDoc.getDocState());
        this.operatorId = operatorId;
    }
}
