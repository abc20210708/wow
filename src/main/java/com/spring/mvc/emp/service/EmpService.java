package com.spring.mvc.emp.service;

import com.spring.mvc.emp.domain.Emp;
import com.spring.mvc.emp.dto.ModEmp;
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

    //글쓰기 중간처리
    public boolean write(Emp emp) {
        return empMapper.insert(emp);
    }

    //상세조회 중간 처리
    public Emp get(Long empNo) {
        return empMapper.getContent(empNo);
    }

    //수정 중간 처리
    public boolean update(ModEmp emp) {
        empMapper.update(emp);
        return true;
    }

    //삭제 중간 처리
    public void remove(Long empNo) {
        empMapper.delete(empNo);
    }




}//end class
