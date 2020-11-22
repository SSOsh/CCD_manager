<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-11-10
  Time: 오후 5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.net.URLDecoder"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/forumMain.css" rel="stylesheet" type="text/css">
    <script>
        function goBack(){
            alert("이전 화면으로 돌아갑니다.")
        }
    </script>
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<% String checked = request.getParameter("selected");%>
<%--그냥 checked로 받으면 한글이 깨져유--%>
<% request.getSession().setAttribute("selected",checked); %>
<%--여기서 세션에 저장, checked는 한글깨진 상태--%>

<div class="contents">
    <div class="divsize">
        <h2>게시판 수정</h2>

        <hr class="hrPink">

        <div>
            <fieldset class="bookLookup">
                <form class="formsize" method="POST" accept-charset="UTF-8">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>게시판 수정</h3>
                        </div>

                        <div class="inputGroup2">
                            <br>
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">게시판명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="새로운 게시판명"
                                   name="newTitle"> <%--aria-describedby="base-addon1" autocomplete="off"--%>
                        </div>

                        <div class="inputGroup3">
                            <br>
                            <input type="submit" class="inquiryBtn" value="수정" formaction="/ModifyForum">
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>


        <a href="../ForumView/forumMain.jsp"><input class="prevBtn" type="button" value="이전" onclick="goBack()"></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>