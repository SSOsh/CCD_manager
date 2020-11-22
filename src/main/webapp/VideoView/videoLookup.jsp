<%@ page import="javax.swing.*" %><%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-11-21
  Time: 오후 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/videoMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <form class="formsize" method="POST" accept-charset="UTF-8">
            <h2><a href="${pageContext.request.contextPath}/VideoView/videoLookup.jsp">도서관련영상 조회</a></h2>
            <hr class="hrPink">

            <input type="number" class="form-control" placeholder="숫자만 입력하세요!" name="count">
            <br>
            <input type="submit" class="inquiryBtn2" value="조회" formaction="/LookupVideo">

        </form>
    </div>
</div>
</body>
</html>
