<%@ page import="model.CategoryInfo" %>
<%@ page import="java.util.ArrayList" %>
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
    <script language="javascript">
        //삭제버튼 메서드
        //팝업 띄우는 거
        function popUp(){
            alert("성공적으로 삭제되었습니다!")
        }

        function inquiry(){
            alert("저장된 카테고리 리스트를 불러옵니다.")
        }

        function mvEnrl(){
            alert("성공적으로 등록되었습니다!")
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
        <h2><a href="${pageContext.request.contextPath}/CategoryView/categoryMain.jsp">카테고리 관리</a></h2>
        <hr class="hrPink">
        <div>
            <fieldset class="bookLookup">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3 class="myH3">카테고리 등록</h3>
                        </div>

                        <div class="inputGroup2">
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">카테고리 ID</span>
                            </div>
                            <input type="text" class="form-control" placeholder="카테고리 ID 입력"
                                   name="cid"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon2">카테고리명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="카테고리명 입력"
                                   name="cn"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon3">Depth1</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Depth1 입력"
                                   name="cd1"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon4">Depth2</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Depth2 입력"
                                   name="cd2"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon5">Depth3</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Depth3 입력"
                                   name="cd3"> <%--aria-describedby="base-addon2" autocomplete="off"--%>
                        </div>

                        <div class="inputGroup3">
                            <br>
                            <input type="submit" class="enrollBtn" value="등록" formaction="/EnrollCategory">
                        </div>
                    </div>
            </fieldset>
        </div>

        <hr class="hrPink">
        <br>
        <h2>카테고리 조회</h2>
        <table class="bookTableHeader">
            <tr>
                <td align="center">

                    <div style="width: 100%; height:20px;">
                        <table width="100%" class="firstRow" cellspacing="1">
                            <tr align="center" height="20">
                                <th width="5%">No.</th>
                                <th width="10%">ID</th>
                                <th width="20%">카테고리명</th>
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

                    <%! int i=1;%>

                    <div style="overflow: auto;width: 100%;height: 200px;">
                        <table class="tableBody" width="100%" ; cellspacing="1" border="1" style="table-layout: fixed">
                            <%
                                if (request.getAttribute("categoryInfoList") != null) {
                                    ArrayList<CategoryInfo> arr = (ArrayList<CategoryInfo>) request.getAttribute("categoryInfoList");
                                    for (CategoryInfo categoryInfoList : arr) {
                                        pageContext.setAttribute("categoryInfoList", categoryInfoList);
                            %>
                            <tr>
                                <td width="5%"><%=i%></td>
                                <td width="10%">${categoryInfoList.categoryID}</td>
                                <td width="20%">${categoryInfoList.categoryName}</td>
                                <td width="20%">${categoryInfoList.categoryDepth1}</td>
                                <td width="20%">${categoryInfoList.categoryDepth2}</td>
                                <td width="20%">${categoryInfoList.categoryDepth3}</td>
                                <td width="5%"><input type="radio" name="selected" value="${categoryInfoList.categoryID}"></td>
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

        <input class="modifyBtn" type="submit" value="수정" formaction="../CategoryView/categoryModi.jsp" onclick="mvModi()">
        <input class="deleteBtn" type="submit" value="삭제" formaction="/DeleteCategory" onclick="popUp()">
        <input class="inquiryBtn" type="submit" value="조회" formaction="/LookupCategory" onclick="inquiry()">
    </div>
    </form>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>
