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
    <script language="javascript">
        //삭제버튼 메서드
        //팝업 띄우는 거
        function popUp(){
            alert("성공적으로 삭제되었습니다!")
        }
    </script>
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <%--폼태그로 한번 싸볼까요? 20-11-16 승환 --%>
    <form class="formsize" method="POST" accept-charset="UTF-8">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/BookView/bookMain.jsp">책 정보 관리</a></h2>
        <hr class="hrPink">
        <div>
            <fieldset class="bookLookup">
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
                            <input type="submit" class="inquiryBtn" value="검색" formaction="/LookupBook">
                        </div>
                    </div>
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
                                <th width="5%">ID</th>
                                <th width="20%">이미지</th>
                                <th width="10%">제목</th>
                                <th width="10%">저자</th>
                                <th width="5%">별점</th>
                                <th width="30%">요약설명</th>
                                <th width="10%">출판사</th>
                                <th width="5%">선택</th>
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
                                <td width="5%">${Integer.toString(n)}</td>
                                <td width="5%">${bookList.bookId}</td>
                                <td width="20%">${bookList.bookCoverUrl}</td>
                                <td width="10%">${bookList.title}</td>
                                <td width="10%">${bookList.author}</td>
                                <td width="5%">${bookList.starRating}</td>
                                <td width="30%">${bookList.summarize}</td>
                                <td width="10%">${bookList.publisher}</td>
                                <td width="5%"><input type="radio" name="selected" value="${bookList.bookId}"></td>
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

        <%-- form태그에서 action지정안해줘도 formaction으로 분리시켜서 매핑가능 --%>
        <input type="submit" class="deleteBtn" value="삭제" formaction="/DeleteBook" onclick="popUp()">
    </div>
    </form>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
