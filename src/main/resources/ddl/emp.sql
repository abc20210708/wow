
CREATE SEQUENCE seq_emp;

DROP TABLE emp;
CREATE TABLE emp (
    emp_no NUMBER(10),
    writer VARCHAR2(20) NOT NULL,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000),
    view_cnt NUMBER(10) DEFAULT 0,
    reg_date DATE DEFAULT SYSDATE,
    CONSTRAINT pk_emp PRIMARY KEY (emp_no)
);


SELECT * FROM emp;
INSERT INTO
    emp (emp_no, writer, title, content)
    VALUES (seq_emp.nextval,  '박사원', '임시로 저장함','뢀뢀뢀뢀롸!');
COMMIT;