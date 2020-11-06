<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-10-27
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/memberMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/MemberView/memberMain.jsp">회원정보 관리</a></h2>
        <hr class="hrPink">
        <div>
            <fieldset class="bookLookup">
                <form class="formsize" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>회원 검색</h3>
                        </div>

                        <div class="inputGroup2">
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">성명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="성명 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon2">닉네임</span>
                            </div>
                            <input type="text" class="form-control" placeholder="닉네임 입력"
                                   name="author"> <%--aria-describedby="base-addon2" autocomplete="off"--%>
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
                                <th width="20%">성명</th>
                                <th width="20%">ID</th>
                                <th width="20%">닉네임</th>
                                <th width="30%">이메일</th>
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
                            <!--각 행마다 <a href> 태그 넣으면 행 클릭시 그 공지사항으로 이동하게 할 수 있을 듯-->
                            <tr>
                                <td width="5%">1</td>
                                <td width="20%">손승환</td>
                                <td width="20%">ssh5959</td>
                                <td width="20%">양호동책벌레</td>
                                <td width="30%">member@naver.com</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="5%">2</td>
                                <td width="20%">이성수</td>
                                <td width="20%">Lee8282</td>
                                <td width="20%">프로젝트노예</td>
                                <td width="30%">pjslave@kumoh.ac.kr</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="5%">3</td>
                                <td width="20%">도수호</td>
                                <td width="20%">suho5252</td>
                                <td width="20%">무시무시한바지</td>
                                <td width="30%">dorume@gmail.com</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="5%">4</td>
                                <td width="20%">황주희</td>
                                <td width="20%">hjh2222</td>
                                <td width="20%">소식하는사람</td>
                                <td width="30%">hwang@naver.com</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>
                            <!--11 04 승환 추가한 예시에유-->
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>

        <a href="../DefaultView/Main.jsp"><input class="deleteBtn" type="button" value="삭제" onclick="remove()"></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
