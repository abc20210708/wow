package com.spring.mvc.emp.service;

import com.spring.mvc.emp.domain.Emp;
import com.spring.mvc.emp.repository.EmpMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmpService {

    private final EmpMapper empMapper;

    //게시물 목록 중간 처리
    public List<Emp> getList() {
        List<Emp> articles = empMapper.getArticles();
        return articles;
    }

}
