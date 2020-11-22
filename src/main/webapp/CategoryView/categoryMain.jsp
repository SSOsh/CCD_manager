<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-10-27
  Time: 오후 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/categoryMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <h2>카테고리 관리</h2>
        <hr class="hrPink">
        <div>
            <fieldset class="bookLookup">
                <form class="formsize" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>카테고리 등록</h3>
                        </div>

                        <div class="inputGroup2">
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">카테고리명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="카테고리명 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon2">Depth1</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Depth1 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon3">Depth2</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Depth2 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon4">Depth3</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Depth3 입력"
                                   name="author"> <%--aria-describedby="base-addon2" autocomplete="off"--%>
                        </div>

                        <div class="inputGroup3">
                            <br>
                            <button type="submit" class="inquiryBtn">등록</button>
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>

        <hr class="hrPink">
        <br>
        <h2><a href="${pageContext.request.contextPath}/CategoryView/categoryMain.jsp">카테고리 조회</a></h2>
        <table class="bookTableHeader">
            <tr>
                <td align="center">

                    <div style="width: 100%; height:20px;">
                        <table width="100%" class="firstRow" cellspacing="1">
                            <tr align="center" height="20">
                                <th width="5%">No.</th>
                                <th width="30%">카테고리명</th>
                                <th width="20%">Depth1</th>
                                <th width="20%">Depth2</th>
                                <th width="20%">Depth3</th>
                                <th width="5%">선택</th>
                            </tr>
                        </table>
                    </div>
                    <%--이까지 테이블 헤더 고정 끝--%>
                    <%--이까지 테이블 바디 스크롤 시작--%>
                    <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                    <div style="overflow: auto;width: 100%;height: 200px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <!--11 04 승환 추가한 예시에유-->
                            <tr>
                                <td width="5%">1</td>
                                <td width="30%">국내도서</td>
                                <td width="20%">소설/시/희곡</td>
                                <td width="20%">한국소설</td>
                                <td width="20%">2000년대 이후 한국소설</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="5%">2</td>
                                <td width="30%">외국도서</td>
                                <td width="20%">소설/시/희곡</td>
                                <td width="20%">소설</td>
                                <td width="20%">판타지</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <!--11 04 승환 추가한 예시에유-->
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>

        <a href="../DefaultView/Main.jsp"><input class="modifyBtn" type="button" value="수정" onclick="modify()"></a>
        <a href="../DefaultView/Main.jsp"><input class="deleteBtn" type="button" value="삭제" onclick="remove()"></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
