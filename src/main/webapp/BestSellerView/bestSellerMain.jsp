<%@ page import="model.Book" %>
<%@ page import="java.util.ArrayList" %>
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
    <script language="javascript">
        function popUp(){
            alert("베스트 셀러 목록을 불러옵니다.")
        }
    </script>
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <form class="formsize" method="POST" accept-charset="UTF-8">
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
                                    <th width="10%">이미지</th>
                                    <th width="20%">제목</th>
                                    <th width="10%">저자</th>
                                    <th width="5%">별점</th>
                                    <th width="30%">요약설명</th>
                                    <th width="10%">출판사</th>
                                </tr>
                            </table>
                        </div>
                        <%--이까지 테이블 헤더 고정 끝--%>
                        <%--이까지 테이블 바디 스크롤 시작--%>
                        <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                        <%! int i=1;%>

                        <div style="overflow: auto;width: 100%;height: 500px;">
                            <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                                <%
                                    if (request.getAttribute("bookList") != null) {
                                        ArrayList<Book> arr = (ArrayList<Book>) request.getAttribute("bookList");
                                        for (Book bookList : arr) {
                                            pageContext.setAttribute("bookList", bookList);
                                %>
                                <tr>
                                    <td width="5%"><%=i%></td>
                                    <td width="5%">${bookList.bookID}</td>
                                    <td width="10%"><img src="${bookList.bookCoverUrl}" width="auto" height="80px"></td>
                                    <td width="20%">${bookList.title}</td>
                                    <td width="10%">${bookList.author}</td>
                                    <td width="5%">${bookList.starRating}</td>
                                    <td width="30%">${bookList.summarize}</td>
                                    <td width="10%">${bookList.publisher}</td>
                                </tr>
                                <%
                                            i++;
                                        }
                                        i=1;
                                    }
                                %>
                            </table>
                        </div>
                        <!--테이블 내용 스크롤 끝-->
                    </td>
                </tr>
            </table>

            <input type="submit" class="deleteBtn" value="조회" formaction="/LookupBestSeller" onclick="popUp()">
        </div>
        </div>
    </form>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->
</div>
</body>
</html>
