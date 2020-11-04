<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-10-27
  Time: 오후 2:22
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
        <h2>공지사항 관리</h2>
        <hr>
        <div>
            <fieldset class="bookLookup">
                <form class="formsize" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>공지사항</h3>
                        </div>

                        <div class="inputGroup2">
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">검색명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="검색어 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon2">검색명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="검색어 입력"
                                   name="author"> <%--aria-describedby="base-addon2" autocomplete="off"--%>
                        </div>

                        <div class="inputGroup3">
                            <br>
                            <button type="submit" class="inquiryBtn">검색</button>
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>

        <hr>

        <a href="../DefaultView/Main.jsp"><input class="deleteBtn" type="button" value="삭제" onclick="remove()"></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
