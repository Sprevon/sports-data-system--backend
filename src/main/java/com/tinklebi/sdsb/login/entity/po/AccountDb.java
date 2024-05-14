package com.tinklebi.sdsb.login.entity.po;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/31 20:58
 */
import com.tinklebi.sdsb.login.entity.vo.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountDb extends Account {

    private static final long serialVersionUID = 6389794820620384649L;
    /**
     * 操作人编号
     */
    private String operatorId;

    public AccountDb(Account account, String operatorId) {
        super(account.getUsername(), account.getPassword(), account.getAuthority());
        this.operatorId = operatorId;
    }
}
