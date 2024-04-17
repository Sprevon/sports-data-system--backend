package com.tinklebi.sdsb.notes.service;

import com.tinklebi.sdsb.notes.dao.AuthorArticleDao;
import com.tinklebi.sdsb.notes.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/4/17 10:42
 */
@Service
public class AuthorArticleService{
    @Autowired
    private AuthorArticleDao authorArticleDao;

    /**
     * 根据作者id查找
     * @param authId
     * @param page
     * @return
     */
    public Page<Article> findByAuthId(int authId, int page){
        Pageable pageable = PageRequest.of(page, 2, Sort.by("artId"));
        return authorArticleDao.selectById(authId, pageable);
    }

    /**
     * 根据作者的id和姓名查找
     * @param authId
     * @param authName
     * @param page
     * @return
     */
    public Page<Article> findByIdAndName(int authId, String authName, int page){
        Pageable pageable = PageRequest.of(page, 2, Sort.by("artId"));
        return authorArticleDao.selectByIdAndName(authId, authName, pageable);
    }

    /**
     * 根据作者id删除作品
     * @param authId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(int authId){
        return authorArticleDao.deleteByAuthId(authId);
    }
}
