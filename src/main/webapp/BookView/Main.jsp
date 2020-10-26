<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-10-24
  Time: 오후 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/Main.css" rel="stylesheet" type="text/css">
    <script language="javascript">
        //사이드바
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }

        //사이드바 끝
    </script>
</head>

<body>
<h1><a href="${pageContext.request.contextPath}/BookView/Main.jsp">북돋다 관리자 페이지</a></h1> <!--클릭하면 새로고침되게 했음-->
<hr class="myhr">
    <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="#">회원정보 관리</a> <!--이런식으로 하면 새화면으로 연결은 되는데 중간에 넣는건 어떡할지?-->
        <a href="${pageContext.request.contextPath}/BookView/bookMain.jsp">책정보 관리</a>
        <a href="#">카테고리 관리</a>
        <a href="#">베스트셀러 조회</a>
        <a href="#">도서관련영상 조회</a>
        <a href="#">게시판 관리</a>
        <a href="#">게시물 관리</a>
        <a href="#">댓글 관리</a>
        <a href="#">공지사항 관리</a>
    </div>
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;메뉴</span>
    <!--각자 추가하는 부분은 이런식으로 레이아웃 구성해서 하면 될거같아서 해놓음, main.css파일에 간격 참고-->
</body>
</html>
