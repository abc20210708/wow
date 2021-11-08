package com.spring.mvc.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Board {

    private Long boardNo ; //글번호
    private String writer; //작성자
    private String title; //글제목
    private String content; //글내용

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
}//end class