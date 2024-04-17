package com.tinklebi.sdsb.notes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/4/17 9:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_article")
public class Article implements Serializable {

    private static final long serialVersionUID = -7779296584074997368L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "art_id")
    private int artId;

    @Column(name = "art_cont")
    private String artCont;

    @ManyToOne(targetEntity = Author.class,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "auth_id", referencedColumnName = "auth_id")
    private Author author;

    @Override
    public String toString(){
        return "{art_id: " + artId + ", art_cout: " + artCont + ", auth_id: " + author.getAuthId()
                + ", auth_name: " + author.getAuthName() + "}";
    }
}
