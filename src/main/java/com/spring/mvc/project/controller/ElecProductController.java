package com.spring.mvc.project.controller;


import com.spring.mvc.project.domain.ElecProduct;
import com.spring.mvc.project.service.ElecProductService;
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
public class ElecProductController {

    private ElecProductService elecProductService;

    @Autowired
    public ElecProductController(ElecProductService elecProductService) {
        this.elecProductService = elecProductService;
    }

    //상품 전체 조회
    @GetMapping("/product/list")
    public String list(Model model) {
        log.info("상품 목록 조회 GET!");
        List<ElecProduct> elecProductList = elecProductService.getList();
        model.addAttribute("elec",elecProductList);
        return "project/csUser/list";
    }

}//end class
