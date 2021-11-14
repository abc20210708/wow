package com.spring.mvc.emp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Setter @Getter @ToString
public class Emp {

    private Long empNo; //사원 번호
    private String writer; //작성자
    private String title; //글제목
    private String content; // 글내용
    private Date regDate; //작성시간
    private int viewCnt; //조회수

    private String regDateStr; //포맷팅된 날짜문자열

    private static long seq;

    public Emp() {
        this.empNo = ++seq;
    }

    public Emp(String writer, String title, String content) {
        this();
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Emp(ResultSet rs) throws SQLException {
        this.empNo = rs.getLong("emp_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
    }

}//end class
