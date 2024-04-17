package com.tinklebi.sdsb.serviceTests;

import com.tinklebi.sdsb.notes.entity.Article;
import com.tinklebi.sdsb.notes.service.AuthorArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/4/17 10:46
 */
@SpringBootTest
public class AuthorArticleServiceTest {
    @Autowired
    private AuthorArticleService authorArticleService;

    /**
     * 根据作者id查询文章信息
     */
    @Test
    public void testFindByAuthId(){
        Page<Article> articleList = authorArticleService.findByAuthId(1, 0);
        System.out.println(articleList.getContent());
        Page<Article> articleList2 = authorArticleService.findByAuthId(1, 1);
        System.out.println(articleList2.getContent());
        Page<Article> articleList3 = authorArticleService.findByAuthId(2, 0);
        System.out.println(articleList3.getContent());
    }

    /**
     * 根据作者名和作者id查询文章信息
     */
    @Test
    public void testFindByIdAndName(){
        Page<Article> articleList = authorArticleService.findByIdAndName(1,"Mike", 0);
        System.out.println(articleList.getContent());
        Page<Article> articleList2 = authorArticleService.findByIdAndName(1, "Mike",1);
        System.out.println(articleList2.getContent());
        Page<Article> articleList3 = authorArticleService.findByIdAndName(2, "Mike", 0);
        System.out.println(articleList3.getContent());
    }

    /**
     * 根据作者id删除作者对应的文章
     */
    @Test
    public void testDeleteById(){
        Page<Article> articles = authorArticleService.findByAuthId(2, 0);
        System.out.println(articles.getContent());
        int deleteItems = authorArticleService.deleteById(2);
        System.out.println(deleteItems + "items deleted");
        articles = authorArticleService.findByAuthId(2 ,0);
        System.out.println(articles.getContent());
    }
}
