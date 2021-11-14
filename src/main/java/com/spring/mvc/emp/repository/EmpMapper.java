package com.spring.mvc.emp.repository;

import com.spring.mvc.emp.domain.Emp;
import com.spring.mvc.emp.dto.ModEmp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    //게시물 목록 조회
    List<Emp> getArticles();

    //게시물 상세 조회
    Emp getContent(Long empNo);

    //게시물 등록
    boolean insert(Emp emp);

    //게시물 삭제
    boolean delete(Long empNo);

    //게시물 수정
    boolean update(ModEmp emp);

}//end cslss
