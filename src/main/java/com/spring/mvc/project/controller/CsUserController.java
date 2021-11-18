package com.spring.mvc.project.controller;


import com.spring.mvc.project.domain.CsUser;
import com.spring.mvc.project.service.CsUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/project")
public class CsUserController {

    private final CsUserService csUserService;

    @Autowired
    public CsUserController(CsUserService csUserService) {
        this.csUserService = csUserService;
    }

    //회원 전제 초회
    @GetMapping("/list")
    public String list(Model model) {
        log.info ("회원 전체 조회 GET!");
        List<CsUser> csUserList = csUserService.getList();
        model.addAttribute("cs",csUserList);
        return "project/csUser/list";
    }

    //회원 가입 요청 - 화면
    @GetMapping("/write")
    public String write() {
        log.info("회원 가입 화면 요청! GET!");
        return "project/csUser/write";
    }

    //회원 가입 요청
    @PostMapping("/write")
    public String write(CsUser csUser) {
        log.info("회원 가입 요청! ==> POST!" + csUser);
        csUserService.write(csUser);
        return "redirect:/project/list";
    }




}//end class
