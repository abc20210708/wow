package com.spring.mvc.project.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Getter @Setter
@ToString @NoArgsConstructor
public class ElecProduct {

    private String productCode;
    private String productName;
    private Date makeDate;

    public ElecProduct(String productCode, String productName, Date makeDate) {
        this.productCode = productCode;
        this.productName = productName;
        this.makeDate = makeDate;
    }

    public ElecProduct(ResultSet rs) throws SQLException {
        this.productCode = rs.getString("product_code");
        this.productName = rs.getString("product_name");
        this.makeDate = rs.getDate("make_date");

    }
}
