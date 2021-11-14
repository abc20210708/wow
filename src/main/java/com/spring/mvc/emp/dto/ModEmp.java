package com.spring.mvc.emp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ModEmp {

    private Long empNo;
    private String writer;
    private String title;
    private String content;

}
