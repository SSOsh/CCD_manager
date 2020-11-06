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
        <h2><a href="${pageContext.request.contextPath}/NoticeView/noticeMain.jsp">공지사항 관리</a></h2>

        <hr class="hrPink">

        <table class="bookTableHeader">
            <tr>
                <td align="center">

                    <div style="width: 100%; height:20px;">
                        <table border="0" width="100%" class="firstRow" cellspacing="1">
                            <tr align="center" height="20">
                                <th width="10%">No.</th>
                                <th width="70%">제목</th>
                                <th width="10%">구분</th>
                                <th width="10%">선택</th>
                            </tr>
                        </table>
                    </div>
                    <%--이까지 테이블 헤더 고정 끝--%>
                    <%--이까지 테이블 바디 스크롤 시작--%>

                    <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                    <div style="overflow: auto;width: 100%;height: 200px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <!--11 04 승환 추가한 예시에유-->
                            <!--각 행마다 <a href> 태그 넣으면 행 클릭시 그 공지사항으로 이동하게 할 수 있을 듯-->
                            <tr>
                                <td width="10%">1</td>
                                <td width="70%"><a href="${pageContext.request.contextPath}/NoticeView/noticeLookupDetail.jsp">**11/2 공지합니다**</a></td>
                                <td width="10%">일반</td>
                                <td width="10%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="10%">2</td>
                                <td width="70%"><a href="${pageContext.request.contextPath}/NoticeView/noticeLookupDetail.jsp">**11/4 공지합니다**</a></td>
                                <td width="10%">일반</td>
                                <td width="10%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="10%">3</td>
                                <td width="70%"><a href="${pageContext.request.contextPath}/NoticeView/noticeLookupDetail.jsp">**필독사항**</a></td>
                                <td width="10%">중요</td>
                                <td width="10%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="10%">4</td>
                                <td width="70%"><a href="${pageContext.request.contextPath}/NoticeView/noticeLookupDetail.jsp">**앱 버전 릴리즈**</a></td>
                                <td width="10%">업데이트</td>
                                <td width="10%"><input type="radio" name="selected"></td>
                            </tr>
                            <!--11 04 승환 추가한 예시에유-->
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>

        <a href="../NoticeView/noticeReg.jsp"><input class="registerBtn" type="button" value="등록" onclick=""></a>
        <a href="../NoticeView/noticeModi.jsp"><input class="modifyBtn" type="button" value="수정" onclick=""></a>
        <a href="../NoticeView/noticeMain.jsp"><input class="deleteBtn" type="button" value="삭제" onclick=""></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
