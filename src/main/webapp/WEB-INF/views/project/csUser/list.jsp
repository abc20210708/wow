<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">



<head>
    <div class="wrap">

        <div class="btn-group btn-group-lg custom-btn-group" role="group">

            <button id="list" type="button" class="btn btn-dark">회원목록</button>
            <button id="join" type="button" class="btn btn-warning">회원가입</button>
         
            <button id="elec" type="button" class="btn btn-warning">상품</button>
            

        </div>
    </div>

    <script>
        // 회원 목록 버튼 이벤트
        const $listBtn = document.getElementById('list');

        $listBtn.onclick = e => {
            var list = '<c:out value="${cs}"/>';
            console.log(list);
        };

        // 회원 가입 버튼 이벤트
        const $joinBtn = document.getElementById('join');

        $joinBtn.onclick = e => {
            location.href = '/project/write';
        };

        // 상품 버튼 이벤트
        const $elecBtn = document.getElementById('elec');

        $elecBtn.onclick = e => {
            //location.href = '/project/product/list';
            var elecList = '<c:out value="${elec}"/>';
            console.log(elecList);
        };

      
    </script>