package com.spring.mvc.project.controller;


import com.spring.mvc.project.domain.CsUser;
import com.spring.mvc.project.service.CsUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/list")
    public String list(Model model) {
        log.info ("회원 전체 조회 GET!");
        List<CsUser> csUserList = csUserService.getList();
        model.addAttribute("cs",csUserList);
        return "project/list";
    }
}
