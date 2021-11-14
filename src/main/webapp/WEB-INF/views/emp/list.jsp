<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>

    <@% include file="../include/static-head.jsp" %>

<style>

    .emp-list {
        width: 70%;
        margin: 0 auto;
    }

    .emp-list .articles {
        margin: 250px auto 100px;
        border-collapse: collapse;
        font-size: 1.5em;
        border-radius: 10px;
    }
    
    .emp-list .btn-write {
        text-align: right;
        position: relative;
        top: -70px;
    }

</style>

</head>

<body>

    <div class="wrap">

        <%@ include file="../include/header.jsp" %>

        <div class="emp-list">
            <table class="table table-success table-striped articles">
                <tr>
                    <th>글번호</th>
                    <th>작성자</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성시간</th>
                </tr>

                <c:forEach>
                    <tr>
                        <td>${emp.empNo}</td>
                        <td>${emp.writer}</td>
                        <td>${emp.title}</td>
                        <td>0</td>
                        <td></td>
                    </tr>


                </c:forEach>





            </table>

            <div class="btn-write">
                <a class="btn btn-outline-danger btn-lg" href="/emp/write">글쓰기</a>
            </div>

        </div>

            <%@ include file="../include/footer.jsp" %>

    </div>

    <script>

    </script>


</body>

</html>