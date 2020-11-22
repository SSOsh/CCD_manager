<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-11-18
  Time: 오후 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/bookMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsizeHome">
        <img src=${pageContext.request.contextPath}/image/home3.png width="1020" height="510">
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
