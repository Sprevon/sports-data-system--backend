package com.tinklebi.sdsb.dbTests;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.DeleteRequest;
import com.tinklebi.sdsb.notes.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/4/24 10:22
 */
@SpringBootTest
public class AuthorMongoDBTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    private String id;

    @Test
    void testInsert(){
        Author author = new Author();
        author.setAuthName("Sherry");
        author.setAuthId(6);
        System.out.println(mongoTemplate.findAll(Author.class));
        Author insertedAuthor = mongoTemplate.insert(author);
        id = insertedAuthor.getId();
        System.out.println("插入的Id为：" + id);
        System.out.println(mongoTemplate.findAll(Author.class));
    }

    @Test
    void testDelete(){
        Author author = mongoTemplate.findOne(new Query(Criteria.where("authId").is(6)), Author.class);
        assert author != null;
        Query query = new Query(Criteria.where("authId").is(author.getAuthId()));
        System.out.println(mongoTemplate.findAll(Author.class));
        DeleteResult deleted = mongoTemplate.remove(query, Author.class);
        System.out.println("删除行数：" + deleted.getDeletedCount());
        System.out.println(mongoTemplate.findAll(Author.class));
    }

    @Test
    void testUpdate(){
        Author author = mongoTemplate.findOne(new Query(Criteria.where("authId").is(5)), Author.class);
        assert author != null;
        author.setAuthName("Johnnnn");
        Query query = new Query(Criteria.where("id").is(author.getId()));
        Update update = new Update();
        update.set("authName", author.getAuthName());
        System.out.println("修改前：" + mongoTemplate.find(query, Author.class));
        UpdateResult updateResult = mongoTemplate.upsert(query, update, Author.class);
        System.out.println("修改文档数：" + updateResult.getModifiedCount());
        System.out.println("修改后：" + mongoTemplate.find(query, Author.class));
    }

    @Test
    void testFind(){
        List<Author> authors = mongoTemplate.findAll(Author.class);
        System.out.println(authors);
        Query query = new Query(Criteria.where("authName").is("Mike"));
        List<Author> authors1 = mongoTemplate.find(query, Author.class);
        System.out.println("查询名称为Mike的作者：" + authors1);
        Query query1 = new Query(Criteria.where("authId").is(1));
        List<Author> authors2 = mongoTemplate.find(query1, Author.class);
        System.out.println("查询ID为1的作者：" + authors2);
    }
}
