package com.spring.mvc.project.service;

import com.spring.mvc.project.domain.ElecProduct;
import com.spring.mvc.project.repository.ElecProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ElecProductService {

    private final ElecProductMapper elecProductMapper;

    //상품 조회 중간처리
    public List<ElecProduct> getList() {
        log.info("상품 목록 요청 service!");
        return elecProductMapper.getArticles();
    }


}//end class
