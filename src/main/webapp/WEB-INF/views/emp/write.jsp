<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="../include/static-head.jsp" %>

    <style>
        .modify-container {
            width: 60%;
            margin: 150px auto;
            position: relative;
        }
        .modify-container .main-title {
            font-size: 24px;
            font-weight: 700;
            text-align: center;
            border-bottom: 2px solid rgb(75, 73, 73);
            padding: 0 20px 15px;
            width: fit-content;
            margin: 20px auto 30px;
        }
        .modify-container .main-content {
            border: 2px solid #ccc;
            border-radius: 20px;
            padding: 10px 25px;
            font-size: 1.1em;
            text-align: justify;
            min-height: 400px;
        }
        .modify-container .custom-btn-group {
            position: absolute;
            bottom: -10%;
            left: 50%;
            transform: translateX(-50%);
        }
    </style>


</head>

<body>


    
    <div class="wrap">

    <%@ include file="../include/header.jsp" %>

        <div class="write-container">

            <form action="/board/write" method="posrt" autocomplete="off">

                <div class="mb-3">
                    <label for="exampleFormControlInput1"
                        class="form-label">
                        작성자
                    </label>
                    <input type="text" class="form-control"
                    name="writer">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput2"
                    class="form-label">
                    글제목
                    <input type="text" class="form-control"
                    name="title">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput2"
                    class="form-label">
                    내용
                    <textarea name="contnet"
                    rows="10"></textarea>
                </div>

                <div class="d-grid gap-2">
                    <button class="btn btn-dark" 
                    type="submit">글 작성하기</button>
                    <button id="to-list" class="btn btn-warning"
                     type="button">목록으로</button>
                </div>

            </form>

        </div>

    <%@ include file="../include/footer.jsp" %>

    </div>

    <script>
        //목록 버튼 이벤트
        const $toList = document.getElementById('to-list');
        $toList.onclick = e => {
            location.href = '/emp/list';
        };

    </script>



</body>

</html>