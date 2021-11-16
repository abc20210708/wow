package com.spring.mvc.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Setter @Getter @ToString
public class Board {

    private Long boardNo ; //글번호
    private String writer; //작성자
    private String title; //글제목
    private String content; //글내용

    private Date regDate; //작성시간
    private Date updateDate; //최종 수정 시간
    private int viewCnt; //조회수

    private String regDateStr; //포맷팅된 날짜문자열
    private boolean newFlag; // 신규글 여부

    //자체 생성 데이터 (누적되는 순차번호 반들기 위한) - 글번호
    private static long seq; // Long 타입

    //마킹된 제목
   // private String markTitle;

    //글번호 생성자
    public Board() {
        System.out.println("Board 객체 생성!!");
       this.boardNo = ++seq;

    }

    public Board(String writer, String title, String content) {
        this();
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Board(ResultSet rs) throws SQLException {
        this.boardNo = rs.getLong("board_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
    }
}//end class
