package com.spring.mvc.project.repository;

import com.spring.mvc.project.domain.CsUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CsUserMapperTest {

    @Autowired
    CsUserMapper csUserMapper;

    @Test
    void getArticles() {
        List<CsUser> articles = csUserMapper.getArticles();
        System.out.println("=============================");
        System.out.println("=============================");
        System.out.println("articles = " + articles);
        System.out.println("=============================");

    }

    @Test
    void insert() {

    }

}