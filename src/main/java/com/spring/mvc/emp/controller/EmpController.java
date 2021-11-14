package com.spring.mvc.emp.controller;

import com.spring.mvc.emp.domain.Emp;
import com.spring.mvc.emp.dto.ModEmp;
import com.spring.mvc.emp.service.EmpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    //리스트
    @GetMapping("/list")
    public String list(Model model) {
        log.info("/emp/list GET!! 게시물 목록 요청!");
        List<Emp> empList = empService.getList();
        model.addAttribute("articles",empList);
        return "emp/list";
    }

    //글쓰기 화면 요청
    @GetMapping("/write")
    public String write() {
        log.info("/emp/write GET!! 글쓰기 화면 요청!!");
        return "emp/write";
    }

    //글쓰기 등록 요청
    @PostMapping
    public String write(Emp emp) {
        log.info("/emp/write POST! 글 등록 요청! " + emp);
        empService.write(emp);
        return "redirect:/emp/list";
    }

    //상세 조회 요청
    // board/content?empNo=3
    @GetMapping("/content")
    public String content(Long empNo, Model model) {
        log.info("/emp/content GET! 상세 조회 요청!" + empNo);
        Emp emp = empService.get(empNo);
        model.addAttribute("emp",emp);
        return "emp/content";
    }

    //수정 양식 화면 요청
    @GetMapping("/modify")
    public String modify(Long empNo, Model model) {
        log.info("/emp/modify GET!" + empNo);
        Emp emp = empService.get(empNo);
        model.addAttribute("emp",emp);
        return "emp/modify";
    }

    //수정 요청 처리
    @PostMapping("/modify")
    public String modify(ModEmp emp) {
        log.info("/emp/modify POST! " + emp);
        empService.update(emp);
        return "redirect:/emp/content?empNo=" +emp.getEmpNo();
    }

    //삭제 요청 처리
    @GetMapping("/delete")
    public String delete(Long empNo) {
        log.info("/emp/delete GET! " + empNo);
        empService.remove(empNo);
        return "redirect:/emp/list";
    }

}//end class
