<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-11-06
  Time: 오후 6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/postMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/PostView/postMain.jsp">게시물 관리</a></h2>
        <hr class="hrPink">

        <table class="bookTableHeader">
            <tr>
                <td align="center">

                    <div style="width: 100%; height:20px;">
                        <table width="100%" class="firstRow" cellspacing="1">
                            <tr align="center" height="20">
                                <th width="60%">제목</th>
                                <th width="20%">닉네임</th>
                                <th width="20%">등록일</th>
                            </tr>
                        </table>
                    </div>
                    <%--이까지 테이블 헤더 고정 끝--%>
                    <%--이까지 테이블 바디 스크롤 시작--%>
                    <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                    <div style="width: 100%;height: 20px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <!--11 06 승환 추가한 예시에유-->
                            <tr>
                                <th width="60%">책 바꿔서 읽으실 분 구함</th>
                                <th width="20%">거의동책벌레</th>
                                <th width="20%">2020-11-01</th>
                            </tr>
                        </table>
                    </div>

                    <div style="overflow: auto;width: 100%;height: 300px; margin-top: 6px">
                        <table class="postBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <!--11 06 승환 추가한 예시에유-->
                            <tr>
                                <td width="100%">
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                    솰라솰라 솰라솰라 책 바꿔 읽어줘요오오오오오오 항 항항
                                </td>
                            </tr>
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>

        <a href="../PostView/postMain.jsp"><input class="prevBtn" type="button" value="이전" onclick=""></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
