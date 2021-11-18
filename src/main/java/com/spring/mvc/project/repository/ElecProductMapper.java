package com.spring.mvc.project.repository;

import com.spring.mvc.project.domain.ElecProduct;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;
import java.util.List;

@Mapper
public interface ElecProductMapper {


    //상품 조회
    List<ElecProduct> getArticles();

    //상품 등록

    //상품 삭제
}
