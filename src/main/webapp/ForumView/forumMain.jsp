<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-10-27
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/forumMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <h2>게시판 관리</h2>
        <hr class="hrPink">
        <div>
            <fieldset class="bookLookup">
                <form class="formsize" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>게시판 검색</h3>
                        </div>

                        <div class="inputGroup2">
                            <br>
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">게시판명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="게시판 명을 입력하세요"
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
                        <table border="1" width="100%" class="firstRow" cellspacing="1">
                            <tr align="center" height="20">
                                <th width="20%">No.</th>
                                <th width="60%">게시판명</th>
                                <th width="20%">선택</th>
                            </tr>
                        </table>
                    </div>
                    <%--이까지 테이블 헤더 고정 끝--%>
                    <%--이까지 테이블 바디 스크롤 시작--%>

                    <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                    <div style="overflow: auto;width: 100%;height: 200px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <!--11 01 승환 추가한 예시에유-->
                            <tr>
                                <td width="20%">0</td>
                                <td width="60%">자유게시판</td>
                                <td width="20%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="20%">1</td>
                                <td width="60%">비밀게시판</td>
                                <td width="20%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="20%">2</td>
                                <td width="60%">장터게시판</td>
                                <td width="20%"><input type="radio" name="selected"></td>
                            </tr>
                            <!--11 01 승환 추가한 예시에유-->
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>

        <a href="../DefaultView/Main.jsp"><input class="registerBtn" type="button" value="등록" onclick="register()"></a>
        <a href="../DefaultView/Main.jsp"><input class="modifyBtn" type="button" value="수정" onclick="modify()"></a>
        <a href="../DefaultView/Main.jsp"><input class="deleteBtn" type="button" value="삭제" onclick="remove()"></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
