package com.spring.mvc.emp.controller;

import com.spring.mvc.emp.domain.Emp;
import com.spring.mvc.emp.service.EmpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequestMapping("/emp")
public class EmpController {

    /*
    *  게시물 목록요청: /wow/list: GET
    *  게시물 상세 조회 요청 : /wow/content: GET
    *  게시글 쓰기 화면 요청 : /wow/write: GET
    *  게시글 등록 요청 : /wow/write: POST
    *  게시글 삭제 요청: /wow/delete: GET
    *  게시글 수정화면 요청: /wow/modify: GET
    *  게시글 수정 요청: /wow/modify: POST
    *
    * */

    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        log.info("/wow/list GET!!");
        List<Emp> empList = empService.getList();
        model.addAttribute("emp",empList);
        return "emp/list";
    }


}//end class
