package com.spring.mvc.project.repository;

import com.spring.mvc.project.domain.CsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CsUserMapper {

    //회원 목록 조회
    List<CsUser> getArticles();

    //회원 가입 / 회원 등록
    boolean insert(CsUser csUser);


}
