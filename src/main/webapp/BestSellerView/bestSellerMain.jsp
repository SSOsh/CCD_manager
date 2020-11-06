<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-10-27
  Time: 오후 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/bestSellerMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/BestSellerView/bestSellerMain.jsp">베스트셀러 조회</a></h2>
        <hr class="hrPink">
        <div>
            <table class="bookTableHeader">
                <tr>
                    <td align="center">

                        <div style="width: 100%; height:20px;">
                            <table width="100%" class="firstRow" cellspacing="1">
                                <tr align="center" height="20">
                                    <th width="5%">No.</th>
                                    <th width="5%">ID</th>
                                    <th width="20%">이미지</th>
                                    <th width="20%">제목</th>
                                    <th width="10%">저자</th>
                                    <th width="5%">별점</th>
                                    <th width="25%">요약설명</th>
                                    <th width="10%">출판사</th>
                                </tr>
                            </table>
                        </div>
                        <%--이까지 테이블 헤더 고정 끝--%>
                        <%--이까지 테이블 바디 스크롤 시작--%>
                        <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                        <div style="overflow: auto;width: 100%;height: 200px;">
                            <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                                <!--11 05 승환 추가한 예시에유-->
                                <!--이미지는 img src 형식으로 넣으면 될거같음-->
                                <tr>
                                    <td width="5%">1</td>
                                    <td width="5%">13054</td>
                                    <td width="20%"><img src="${pageContext.request.contextPath}/image/lena_color.bmp" width="60px" height="60px"></td>
                                    <td width="20%">레나레나</td>
                                    <td width="10%">이해연</td>
                                    <td width="5%">4.5</td>
                                    <td width="25%">컴퓨터비전에 나오는 여자이다.</td>
                                    <td width="10%">북스힐</td>
                                </tr>

                                <tr>
                                    <td width="5%">2</td>
                                    <td width="5%">34054</td>
                                    <td width="20%"><img src="${pageContext.request.contextPath}/image/Baboon.bmp" width="60px" height="60px"></td>
                                    <td width="20%">바분</td>
                                    <td width="10%">이해연</td>
                                    <td width="5%">3.5</td>
                                    <td width="25%">컴퓨터비전에 나오는 원숭이다.</td>
                                    <td width="10%">해커스</td>
                                </tr>

                                <!--11 05 승환 추가한 예시에유-->
                            </table>
                        </div>
                        <!--테이블 내용 스크롤 끝-->
                    </td>
                </tr>
            </table>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->
</div>
</body>
</html>
