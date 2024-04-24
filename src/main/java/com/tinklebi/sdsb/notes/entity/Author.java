package com.tinklebi.sdsb.notes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/4/17 9:59
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_author")
@Document(collection = "testCol")
public class Author implements Serializable {
    private static final long serialVersionUID = -6462933427484058074L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id")
    private int authId;

    @Column(name = "auth_name")
    private String authName;

    @OneToMany(mappedBy = "author")
    private List<Article> articleList;

    private String id;

    @Override
    public String toString(){
        return "auth_id: " + authId + ", auth_name: " + authName;
    }
}
