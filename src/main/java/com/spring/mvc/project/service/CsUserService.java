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

    //회원 조회 중간 처리
    public List<CsUser> getList() {
        log.info("목록 서비스 요청");
        return csUserMapper.getArticles();
    }
    
    //회원가입 중간처리
    public boolean write(CsUser csUser) {
        return csUserMapper.insert(csUser);
    }


}//end class

