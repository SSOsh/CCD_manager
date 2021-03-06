<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2020-11-10
  Time: 오후 5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북돋다 관리자 페이지</title>
    <link href="${pageContext.request.contextPath}/css/categoryMain.css" rel="stylesheet" type="text/css">
    <script>
        function goBack(){
            alert("이전 화면으로 돌아갑니다.")
        }
    </script>
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<% String checked = request.getParameter("selected");%>
<%--그냥 checked로 받으면 한글이 깨져유--%>
<% request.getSession().setAttribute("selected",checked); %>
<%--여기서 세션에 저장, checked는 한글깨진 상태--%>

<div class="contents">
    <div class="divsize">
        <h2>카테고리 수정</h2>

        <hr class="hrPink">

        <div>
            <fieldset class="bookLookup">
                <form class="formsize" action="/bookMain" method="POST" accept-charset="UTF-8">
                    <div class="form-inline">
                        <div class="inputGroup1">
                            <h3>카테고리 수정</h3>
                        </div>

                        <div class="inputGroup2">
                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon1">카테고리명</span>
                            </div>
                            <input type="text" class="form-control" placeholder="카테고리명 입력"
                                   name="mcn"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon2">Depth1</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Depth1 입력"
                                   name="mcd1"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon3">Depth2</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Depth2 입력"
                                   name="mcd2"> <%--aria-describedby="base-addon1" autocomplete="off"--%>

                            <div class="inputGroup-prepend">
                                <span class="input-group-text" id="base-addon4">Depth3</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Depth3 입력"
                                   name="mcd3"> <%--aria-describedby="base-addon2" autocomplete="off"--%>
                        </div>

                        <div class="inputGroup3">
                            <br>
                            <input type="submit" class="modiBtn" value="수정" formaction="/ModifyCategory">
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>

        <br>

        <a href="../CategoryView/categoryMain.jsp"><input class="prevBtn" type="button" value="이전" onclick="goBack()"></a>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

</body>
</html>

