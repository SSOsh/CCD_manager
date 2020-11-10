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
    <link href="${pageContext.request.contextPath}/css/commentMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/CommentView/commentMain.jsp">댓글 관리</a></h2>
        <hr class="hrPink">
        <div>
            <fieldset class="bookLookup">
                <form class="formsize" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>댓글 조회</h3>
                        </div>

                        <div class="inputGroup2">
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">댓글 ID</span>
                            </div>
                            <input type="text" class="form-control" placeholder="댓글 ID 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon2">게시물 ID</span>
                            </div>
                            <input type="text" class="form-control" placeholder="게시물 ID 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon3">작성자 ID</span>
                            </div>
                            <input type="text" class="form-control" placeholder="작성자 ID 입력"
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
                                <th width="10%">게시판</th> <!--무슨 게시판인지 이름, forum name -->
                                <th width="20%">게시물 제목</th> <!--무슨 인지 이름, post.title -->
                                <th width="10%">닉네임</th>
                                <th width="40%">내용</th>
                                <th width="10%">날짜</th>
                                <th width="5%">선택</th>
                            </tr>
                        </table>
                    </div>
                    <%--이까지 테이블 헤더 고정 끝--%>
                    <%--이까지 테이블 바디 스크롤 시작--%>
                    <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                    <div style="overflow: auto;width: 100%;height: 200px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <!--11 10 승환 추가한 예시에유-->
                            <tr>
                                <td width="5%">1</td>
                                <td width="10%">자유게시판</td>
                                <td width="20%">책 바꿔서 읽으실 분 구함</td>
                                <td width="10%">팀버지박령</td>
                                <td width="40%">지금도 구하시나요?!!</td>
                                <td width="10%">2020-11-10</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="5%">2</td>
                                <td width="10%">자유게시판</td>
                                <td width="20%">책 바꿔서 읽으실 분 구함</td>
                                <td width="10%">리렁구</td>
                                <td width="40%">저 책이 없는데 교환가능한가요?</td>
                                <td width="10%">2020-11-10</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="5%">3</td>
                                <td width="10%">자유게시판</td>
                                <td width="20%">좋은 책 공유해요~</td>
                                <td width="10%">팀버지박령</td>
                                <td width="40%">혹시 추천하시는 책 있나요?</td>
                                <td width="10%">2020-11-10</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <tr>
                                <td width="5%">4</td>
                                <td width="10%">자유게시판</td>
                                <td width="20%">좋은 책 공유해요~</td>
                                <td width="10%">팀버지박령</td>
                                <td width="40%">해리포터 추천드려요ㅎㅎ</td>
                                <td width="10%">2020-11-10</td>
                                <td width="5%"><input type="radio" name="selected"></td>
                            </tr>

                            <!--11 10 승환 추가한 예시에유-->
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>

        <a href="../CommentView/commentMain.jsp"><input class="deleteBtn" type="button" value="삭제" onclick=""></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
