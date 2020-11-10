<%@ page import="model.Book" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-10-24
  Time: 오후 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/bookMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/BookView/bookMain.jsp">책 정보 관리</a></h2>
        <hr class="hrPink">
        <div>
            <fieldset class="bookLookup">
                <form class="formsize" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>도서 검색</h3>
                        </div>

                        <div class="inputGroup2">
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">도서명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="도서명 입력"
                                   name="title"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon2">저자</span>
                            </div>
                            <input type="text" class="form-control" placeholder="저자이름 입력"
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
                                <th>No.</th>
                                <th>ID</th>
                                <th>이미지</th>
                                <th>제목</th>
                                <th>저자</th>
                                <th>별점</th>
                                <th>요약설명</th>
                                <th>출판사</th>
                                <th>선택</th>
                            </tr>
                        </table>
                    </div>
                    <%--이까지 테이블 헤더 고정 끝--%>
                    <%--이까지 테이블 바디 스크롤 시작--%>

                    <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                    <div style="overflow: auto;width: 100%;height: 200px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <%
                                //no.부분 수정필요
                                if (request.getAttribute("bookList") != null) {
                                    int n =  4;
                                    ArrayList<Book> arr = (ArrayList<Book>) request.getAttribute("bookList");
                                    for (Book bookList : arr) {
                                        pageContext.setAttribute("bookList", bookList);
                            %>
                            <tr>
                                <td>${Integer.toString(n)}</td>
                                <td>${bookList.bookId}</td>
                                <td>${bookList.bookCoverUrl}</td>
                                <td>${bookList.title}</td>
                                <td>${bookList.author}</td>
                                <td>${bookList.starRating}</td>
                                <td>${bookList.summarize}</td>
                                <td>${bookList.publisher}</td>
                                <td><input type="radio" name="selected"></td>
                            </tr>
                            <%
                                        n++;
                                    }
                                }
                            %>
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>
        <%--밑에 처럼 변경해서 서블릿으로 값 받아와야되요-->
<%--            <tbody>--%>
        <%--            <tr class="bookList">--%>
        <%--                <td name="num">1</td>--%>
        <%--                <td name="BookID">1235</td>--%>
        <%--                <td name="bookCoverUrl">이미지파일</td>--%>
        <%--                <td name="title">책11</td>--%>
        <%--                <td name="author">렁구</td>--%>
        <%--                <td name="starRating">5점</td>--%>
        <%--                <td name="summarize">렁구는 어몽어스를 함</td>--%>
        <%--                <td name="publisher">렁구출판</td>--%>
        <%--                <td><input type="radio" name="selected"></td>--%>
        <%--            </tr>--%>
        <%--            </tbody>--%>
        <%--        </table>--%>

        <%--        <input class="deleteBtn" type="button" value="삭제" onclick="remove()"> <!--onclick()에 메서드 차후에 변경 요망-->--%>
        <a href="../BookView/bookMain.jsp"><input class="deleteBtn" type="button" value="삭제" onclick="remove()"></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
