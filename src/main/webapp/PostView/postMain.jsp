<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-10-27
  Time: 오후 2:21
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
        <div>
            <fieldset class="bookLookup">
                <form class="formsize" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>게시물 조회</h3>
                        </div>

                        <div class="inputGroup2">
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">게시판명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="게시판명 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon2">게시물 제목</span>
                            </div>
                            <input type="text" class="form-control" placeholder="게시물 제목 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon3">닉네임</span>
                            </div>
                            <input type="text" class="form-control" placeholder="작성자 닉네임 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>
                        </div>

                        <div class="inputGroup3">
                            <br>
                            <button type="submit" class="inquiryBtn">검색</button>
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>

        <hr class="hrPink">

        <table class="bookTableHeader">
            <tr>
                <td align="center">

                    <div style="width: 100%; height:20px;">
                        <table width="100%" class="firstRow" cellspacing="1">
                            <tr align="center" height="20">
                                <th width="5%">No.</th>
                                <th width="10%">게시물 ID</th>
                                <th width="40%">제목</th>
                                <th width="20%">닉네임</th>
                                <th width="20%">등록일</th>
                                <th width="5%">선택</th>
                            </tr>
                        </table>
                    </div>
                    <%--이까지 테이블 헤더 고정 끝--%>
                    <%--이까지 테이블 바디 스크롤 시작--%>
                    <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                    <div style="overflow: auto;width: 100%;height: 200px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <!--11 06 승환 추가한 예시에유-->
                            <tr>
                                <td width="5%">1</td>
                                <td width="10%">1024</td>
                                <td width="40%"><a href="${pageContext.request.contextPath}/PostView/postLookupDetail.jsp">책 바꿔서 읽으실 분 구함</a></td>
                                <td width="20%">거의동책벌레</td>
                                <td width="20%">2020-11-01</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="5%">2</td>
                                <td width="10%">999</td>
                                <td width="40%"><a href="${pageContext.request.contextPath}/PostView/postLookupDetail.jsp">좋은 책 공유해요~</a></td>
                                <td width="20%">현자</td>
                                <td width="20%">2020-10-31</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <!--11 06 승환 추가한 예시에유-->
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>

        <a href="../PostView/postMain.jsp"><input class="deleteBtn" type="button" value="삭제" onclick=""></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
