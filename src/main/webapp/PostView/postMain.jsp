<%@ page import="model.Post" %>
<%@ page import="java.util.ArrayList" %>
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

<% String checked = request.getParameter("datailLink");%>
<% request.getSession().setAttribute("selected",checked); %>

<div class="contents">
    <form class="formsize" method="POST" accept-charset="UTF-8">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/PostView/postMain.jsp">게시물 관리</a></h2>
        <hr class="hrPink">
        <div>
            <fieldset class="bookLookup">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>게시물 조회</h3>
                        </div>

                        <div class="inputGroup2">
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">게시판명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="게시판명 입력"
                                   name="forumTitle"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon2">게시물 제목</span>
                            </div>
                            <input type="text" class="form-control" placeholder="게시물 제목 입력"
                                   name="postTitle"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon3">닉네임</span>
                            </div>
                            <input type="text" class="form-control" placeholder="작성자 닉네임 입력"
                                   name="nickName"> <%--aria-describedby="base-addon1" autocomplete="off"--%>
                        </div>

                        <div class="inputGroup3">
                            <br>
                            <input type="submit" class="inquiryBtn" value="검색" formaction="/LookupPost">
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

                    <%! int i=1;%>

                    <div style="overflow: auto;width: 100%;height: 500px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <%
                                if (request.getAttribute("postList") != null) {
                                    ArrayList<Post> arr = (ArrayList<Post>) request.getAttribute("postList");
                                    for (Post postList : arr) {
                                        pageContext.setAttribute("postList", postList);
                            %>
                            <tr>
                                <td width="5%"><%=i%></td>
                                <td width="10%">${postList.postID}</td>
                                <td width="40%"><input type="submit" class="myInput" name="onePost" value="${postList.title}" formaction="LookupPostContents"></td>
                                <td width="20%">${postList.nickname}</td>
                                <td width="20%">${postList.date}</td>
                                <td width="5%"><input type="radio" name="selected" value="${postList.postID}"></td>
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
        <%-- form태그에서 action지정안해줘도 formaction으로 분리시켜서 매핑가능 --%>
        <input type="submit" class="deleteBtn" value="삭제" formaction="/DeletePost" onclick="popUp()">
    </div>
    </form>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
