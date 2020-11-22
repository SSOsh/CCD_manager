<%@ page import="model.Notice" %>
<%@ page import="java.util.ArrayList" %>
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
    <script language="javascript">
        //삭제버튼 메서드
        //팝업 띄우는 거
        function popUp(){
            alert("성공적으로 삭제되었습니다!")
        }

        function mvEnrl(){
            alert("등록 창으로 이동합니다.")
        }

        function mvModi(){
            alert("수정 창으로 이동합니다.")
        }
    </script>
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <form class="formsize" method="POST" accept-charset="UTF-8">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/NoticeView/noticeMain.jsp">공지사항 관리</a></h2>

        <hr class="hrPink">

        <table class="bookTableHeader">
            <tr>
                <td align="center">

                    <div style="width: 100%; height:20px;">
                        <table border="0" width="100%" class="firstRow" cellspacing="1">
                            <tr align="center" height="20">
                                <th width="5%">No.</th>
                                <th width="10%">구분</th>
                                <th width="55%">제목</th>
                                <th width="25%">등록일</th>
                                <th width="5%">선택</th>
                            </tr>
                        </table>
                    </div>
                    <%--이까지 테이블 헤더 고정 끝--%>
                    <%--이까지 테이블 바디 스크롤 시작--%>

                    <br> <!--헤더랑 바디 간격 띄우려고 추가-->

                    <%! int i=1;%>

                    <div style="overflow: auto;width: 100%;height: 200px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <%
                                if (request.getAttribute("noticeList") != null) {
                                    ArrayList<Notice> arr = (ArrayList<Notice>) request.getAttribute("noticeList");
                                    for (Notice noticeList : arr) {
                                        pageContext.setAttribute("noticeList", noticeList);
                            %>
                            <tr>
                                <td width="5%"><%=i%></td>
                                <td width="10%">${noticeList.division}</td>
                                <td width="55%"><input type="submit" class="myInput" name="oneNotice" value="${noticeList.title}" formaction="LookupNoticeContents"></td>
                                <td width="25%">${noticeList.date}</td>
                                <td width="5%"><input type="radio" name="selected" value="${noticeList.noticeID}"></td>
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

        <a href="../NoticeView/noticeReg.jsp"><input class="registerBtn" type="button" value="등록" onclick="mvEnrl()"></a>
        <input class="modifyBtn" type="submit" value="수정" formaction="../NoticeView/noticeModi.jsp" onclick="mvModi()">
        <input class="deleteBtn" type="submit" value="삭제" formaction="/DeleteNotice" onclick="popUp()">
        <input class="inquiryBtn2" type="submit" value="조회" formaction="/LookupNotice">
    </div>
    </form>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
