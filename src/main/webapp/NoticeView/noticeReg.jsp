<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-11-06
  Time: 오후 7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/noticeMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <h2>공지사항 등록</h2>

        <hr class="hrPink">

        <div>
            <fieldset class="nReg">
                <form class="" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="">
                        <div class="">
                            <h3>공지사항 등록</h3>
                        </div>

                        <div class="">
                            <div class="formRows">
                                <span class="" id="base-addon1">제목</span>
                            </div>
                            <input type="text" class="ipContents" placeholder="공지사항 제목 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="formRows">
                                <span class="" id="base-addon2">구분</span>
                            </div>
                            <input type="text" class="ipContents" placeholder="공지사항 구분 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="formRows">
                                <span class="" id="base-addon3">공지사항 내용</span>
                            </div>
                            <textarea rows="20" cols="130" class="ipContents"></textarea>
                        </div>

                        <div class="formBtn">
                            <br>
                            <button type="submit" class="inquiryBtn">완료</button>
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>

        <a href="../NoticeView/noticeMain.jsp"><input class="prevBtn" type="button" value="이전" onclick=""></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>