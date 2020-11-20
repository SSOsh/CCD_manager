<%@ page import="model.Notice" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-11-06
  Time: 오후 7:03
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
        <h2><a href="${pageContext.request.contextPath}/NoticeView/noticeMain.jsp">공지사항 관리</a></h2>
        <hr class="hrPink">

        <table class="bookTableHeader">
            <tr>
                <td align="center">

                    <div style="width: 100%; height:20px;">
                        <table width="100%" class="firstRow" cellspacing="1">
                            <tr align="center" height="20">
                                <th width="60%">제목</th>
                                <th width="20%">구분</th>
                                <th width="20%">등록일</th>
                            </tr>
                        </table>
                    </div>
                    <%--이까지 테이블 헤더 고정 끝--%>
                    <%--이까지 테이블 바디 스크롤 시작--%>
                    <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                    <div style="width: 100%;height: 20px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <%
                                if (request.getAttribute("noticeList") != null) {
                                    ArrayList<Notice> arr = (ArrayList<Notice>) request.getAttribute("noticeList");
                                    for (Notice noticeList : arr) {
                                        pageContext.setAttribute("noticeList", noticeList);
                            %>
                            <tr>
                                <th width="60%">${noticeList.title}</th>
                                <th width="20%">${noticeList.division}</th>
                                <th width="20%">${noticeList.date}</th>
                            </tr>
                        </table>
                    </div>

                    <div style="overflow: auto;width: 100%;height: 300px; margin-top: 6px">
                        <table class="noticeBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <tr>
                                <td width="100%">${noticeList.contents}</td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>

        <a href="../NoticeView/noticeMain.jsp"><input class="prevBtn" type="button" value="이전" onclick=""></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>