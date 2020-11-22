<%@ page import="model.Forum" %>
<%@ page import="java.util.ArrayList" %>
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
        <h2><a href="${pageContext.request.contextPath}/ForumView/forumMain.jsp">게시판 관리</a></h2>
        <hr class="hrPink">
        <div>
            <fieldset class="bookLookup">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>게시판 검색</h3>
                        </div>

                        <div class="inputGroup2">
                            <br>
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">게시판명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="게시판명 입력"
                                   name="forumTitle"> <%--aria-describedby="base-addon1" autocomplete="off"--%>
                        </div>

                        <div class="inputGroup3">
                            <br>
                            <input type="submit" class="inquiryBtn" value="검색" formaction="/LookupForum">
                        </div>
                    </div>
            </fieldset>
        </div>

        <hr class="hrPink">

        <table class="bookTableHeader">
            <tr>
                <td align="center">

                    <div style="width: 100%; height:20px;">
                        <table border="0" width="100%" class="firstRow" cellspacing="1">
                            <tr align="center" height="20">
                                <th width="10%">No.</th>
                                <th width="80%">게시판명</th>
                                <th width="10%">선택</th>
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
                                if (request.getAttribute("forumList") != null) {
                                    int n =  4;
                                    ArrayList<Forum> arr = (ArrayList<Forum>) request.getAttribute("forumList");
                                    for (Forum forumList : arr) {
                                        pageContext.setAttribute("forumList", forumList);
                            %>
                            <tr>
                                <td width="10%">${Integer.toString(n)}</td>
                                <td width="80%">${forumList.forumName}</td>
                                <td width="10%"><input type="radio" name="selected" value="${forumList.forumName}"></td>
                            </tr>
                            <%
                                        n++;
                                    }
                                }
                            %>

                            <!--실험중-->
                        </table>
                    </div>
                    <!--테이블 내용 스크롤 끝-->
                </td>
            </tr>
        </table>

        <%-- form태그에서 action지정안해줘도 formaction으로 분리시켜서 매핑가능 --%>
        <a href="../ForumView/forumReg.jsp"><input class="registerBtn" type="button" value="등록" onclick="mvEnrl()"></a>
        <%-- 20-11-19 승환 : jsp로 넘길때 세션에 값을 저장하면 어떨까--%>
        <input class="modifyBtn" type="submit" value="수정" formaction="../ForumView/forumModi.jsp" onclick="mvModi()">
        <input type="submit" class="deleteBtn" value="삭제" formaction="/DeleteForum" onclick="popUp()">
    </div>
    </form>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
