<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">



<head>
    <div class="wrap">

        <div class="btn-group btn-group-lg custom-btn-group" role="group">


            <div class="write-container">

                <form action="/project/write" method="post" autocomplete="off">

                   

                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">아이디(이메일)</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="이메일을 입력해주세요"
                            name="csId">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput2" class="form-label">비밀번호</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="비밀번호를 입력해주세요"
                            name="pw">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput2" class="form-label">이름</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="이름"
                            name="csName">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput2" class="form-label">주소</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="주소"
                            name="address">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput2" class="form-label">우편번호</label>
                        <input type="text"  placeholder="ex) 111,222" name="postalCode">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput2" class="form-label">휴대폰번호</label>
                        <input type="text" laceholder="ex)010-0000-0000" name="phone">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput2" class="form-label">성별</label>
                        <input type="text" placeholder="ex)남자, 여자" name="gender">
                    </div>
                   
                       
                  
                    
                    



                    <div class="d-grid gap-2">
                        <button class="btn btn-dark" type="submit">가입하기</button>
                        <button id="to-list" class="btn btn-warning" type="button">목록으로</button>
                    </div>

                    

                </form>

            </div>

        </div>

    </div>


    <script>
        //목록버튼 이벤트
        const $toList = document.getElementById('to-list');
        $toList.onclick = e => {
            location.href = '/project/list';
        };
    </script>