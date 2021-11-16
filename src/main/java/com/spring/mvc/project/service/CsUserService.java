package com.spring.mvc.project.service;

import com.spring.mvc.project.domain.CsUser;
import com.spring.mvc.project.repository.CsUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class CsUserService {

    private final CsUserMapper csUserMapper;

    //회원조회
    public List<CsUser> getList() {
        return csUserMapper.getArticles();

    }
}
