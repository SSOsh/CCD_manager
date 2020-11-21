<%@ page import="model.Book" %>
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
    <link href="${pageContext.request.contextPath}/css/videoMain.css" rel="stylesheet" type="text/css">
    <%--11 06 승환 - 여기부터 자바스크립트 --%>
    <script src="http://www.youtube.com/player_api"></script>
    <script type="text/javascript">
        //여기 videoId가 유튜브링크복사하면 있는 고유한 식별자
        var player;
        function onYouTubePlayerAPIReady(){
            player = new YT.Player("player",{
                width: "100%",
                height: "500",
                // videoId: "7jKXT4Jdvd4",
                videoId: "<%=Link%>",
                events:{
                    onReady: onPlayerReady,
                    onStateChange: onPlayerStateChange
                }
            });
        }

        //autoplay video
        function onPlayerReady(event){
            event.target.playVideo();
        }

        //when video ends
        function onPlayerStateChange(event){
            if(event.data===0){
                window.location="http://127.0.0.1:8000/";
            }
        }
    </script>
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <form class="formsize" method="POST" accept-charset="UTF-8">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/VideoView/videoMain.jsp">도서관련영상 조회</a></h2>
        <hr class="hrPink">

        <%!
            int cnt;
            int maxCnt;
            String[] videoFullLinks=new String[1000]; //풀링크
            String[] videoLink=new String[10]; //스플릿
            String[] books=new String[1000]; //책제목
            String Link; //찐막링크
        %>

        <%
            if(Link==null){
                if (request.getAttribute("bookList") != null) {
                    cnt=0;
                    ArrayList<Book> arr = (ArrayList<Book>) request.getAttribute("bookList");
                    for (Book bookList : arr) {
                        pageContext.setAttribute("bookList", bookList);
                        videoFullLinks[cnt]=bookList.getVideoUrl(); //비디오 링크 넣어주고
                        books[cnt]=bookList.getTitle(); //제목 넣어주고
                        cnt++;
                    }
                    maxCnt=cnt;
                    cnt=0; //for 문 끝나고 다시 0으로
                }
            }
        %>

        <%
            if (request.getAttribute("count") != null){
                cnt = Integer.parseInt((String)request.getAttribute("count"));
            }
        %>

<%--        id는 player로 설정하고 바디 마지막부분에 [스크립트]에서 유튜브api사용함--%>
<%--        %! 로 선언 / % 에서 코딩 / %= 로 출력--%>
        <h3>원작 책 제목 : <%=books[cnt-1]%></h3>
        <%
            videoLink=videoFullLinks[cnt-1].split("/");
            Link=videoLink[3];
        %>
<%--        액기스 링크는 : <%=Link%>--%>
        <br>
        현재 <%=cnt%> 번 째 영상입니다.
        <br>
        저장된 영상의 갯수는 총 <%=maxCnt%> 개 입니다.
        <div id="player">
            <%--이 안에서 영상 재생--%>
        </div>
        <hr class="hrPink">

        <div class="videoBtn">
<%--            <input type="submit" class="nextBtn" value="다음" formaction="/LookupVideo" onclick="nextB()">--%>
<%--            <a href="${pageContext.request.contextPath}/VideoView/videoMain.jsp"><input class="prevBtn" type="button" value="이전" onclick="prevB()"></a>--%>
            <a href="${pageContext.request.contextPath}/VideoView/videoLookup.jsp"><input class="nextBtn" type="button" value="다른 영상 조회"></a>
        </div>
    </div>
    </form>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->



</body>
</html>
