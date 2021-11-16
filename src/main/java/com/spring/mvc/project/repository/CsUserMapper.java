package com.spring.mvc.project.repository;

import com.spring.mvc.project.domain.CsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CsUserMapper {

    List<CsUser> getArticles();
}
