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
</head>
<body>
<%@include file="../DefaultView/Main.jsp" %>

<div class="contents">
    <div class="divsize">
        <h2><a href="${pageContext.request.contextPath}/VideoView/videoMain.jsp">도서관련영상 조회</a></h2>
        <hr class="hrPink">
<%--        id는 player로 설정하고 바디 마지막부분에 [스크립트]에서 유튜브api사용함--%>
<%--        %! 로 선언 / % 에서 코딩 / %= 로 출력--%>
        <%!String bookTitle;%>
        <%bookTitle="해리포터";%>
        <h3>원작 책 제목 : <%=bookTitle%></h3>

        <div id="player">
            <%--지금 해놓은 영상 url은 이거 : 'https://youtu.be/7jKXT4Jdvd4'--%>
        </div>
        <hr class="hrPink">

        <div class="videoBtn">
        <a href="../VideoView/videoMain.jsp"><input class="prevBtn" type="button" value="이전" onclick=""></a>
        <a href="../VideoView/videoMain.jsp"><input class="nextBtn" type="button" value="다음" onclick=""></a>
        </div>
    </div>
</div>  <!-- 내용 div 끝 마진을 왼쪽에서 190px 띄우는 div 끝-->

<%--11 06 승환 - 여기부터 자바스크립트 --%>
<script src="http://www.youtube.com/player_api"></script>
<script type="text/javascript">
    //여기 videoId가 유튜브링크복사하면 있는 고유한 식별자인데 이걸로 배열을 만들어서 순서대로 돌리면 좋을듯?
    var player;
    function onYouTubePlayerAPIReady(){
        player = new YT.Player("player",{
            width: "100%",
            height: "500",
            videoId: "7jKXT4Jdvd4",
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

</body>
</html>
