package com.tinklebi.sdsb.notes.dao;

import com.tinklebi.sdsb.notes.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/4/17 10:11
 */
public interface AuthorArticleDao extends JpaRepository<Article, Integer> {
    @Query("SELECT art FROM Article art WHERE art.author.authId = :authId")
    Page<Article> selectById(@Param("authId") int authId, Pageable pageable);

    @Query("SELECT art FROM Article art WHERE art.author.authId = :authId and art.author.authName = :authName")
    Page<Article> selectByIdAndName(@Param("authId")int authId, @Param("authName") String authName, Pageable pageable);

    @Modifying
    @Query("DELETE FROM Article art WHERE art.author.authId = :authId")
    int deleteByAuthId(@Param("authId")int authId);
}
