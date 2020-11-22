<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-11-06
  Time: 오후 7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.net.URLDecoder"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/noticeMain.css" rel="stylesheet" type="text/css">
    <script>
        function goBack(){
            alert("이전 화면으로 돌아갑니다.")
        }
    </script>
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<% String checked = request.getParameter("selected");%>
<%--그냥 checked로 받으면 한글 깨짐--%>
<% request.getSession().setAttribute("selected",checked); %>
<%--여기서 세션에 저장, checked는 한글깨진 상태--%>

<div class="contents">
    <div class="divsize">
        <h2>공지사항 수정</h2>

        <hr class="hrPink">
        <div>
            <fieldset class="nReg">
                <form class="" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="">
                        <div class="">
                            <h3>공지사항 수정</h3>
                        </div>

                        <div class="">
                            <div class="formRows">
                                <span class="" id="base-addon1">제목</span>
                            </div>
                            <input type="text" class="ipContents" placeholder="수정할 제목"
                                   name="noticeTitle"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="formRows">
                                <span class="" id="base-addon2">구분</span>
                            </div>
                            <input type="text" class="ipContents" placeholder="수정할 구분명"
                                   name="noticeDivision"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="formRows">
                                <span class="" id="base-addon3">공지사항 내용</span>
                            </div>
                            <textarea rows="20" cols="130" class="ipContents" name="noticeContents"></textarea>
                        </div>

                        <div class="formBtn">
                            <br>
                            <input type="submit" class="inquiryBtn" value="수정" formaction="/ModifyNotice">
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>

        <a href="../NoticeView/noticeMain.jsp"><input class="prevBtn" type="button" value="이전" onclick="goBack()"></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
