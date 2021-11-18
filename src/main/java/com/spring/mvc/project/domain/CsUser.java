package com.spring.mvc.project.domain;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class CsUser {


    private String csId; //회원 아이디
    private String pw;  //회원 비밀번호
    private String csName; //회원 이름
    private String address; //회원 주소
    private int postalCode; //우편번호
    private String phone;   //연락처
    private int grade;      //등급
    private String gender; //성별

    public CsUser(String csId,
                  String pw,
                  String csName,
                  String address,
                  int postalCode,
<<<<<<< HEAD
                  String phone,
                  int grade,
                  String gender) {
=======
                  String phone, int grade, String gender) {
>>>>>>> origin/master
        this.csId = csId;
        this.pw = pw;
        this.csName = csName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.grade = grade;
        this.gender = gender;
    }

    public CsUser(ResultSet rs) throws SQLException {
        this.csId = rs.getString("cs_id");
        this.pw = rs.getString("pw");
        this.csName = rs.getString("cs_name");
        this.address = rs.getString("address");
        this.postalCode = rs.getInt("postal_code");
        this.phone = rs.getString("phone");
        this.grade = rs.getInt("grade");
        this.gender = rs.getString("gender");

    }

}//end class
