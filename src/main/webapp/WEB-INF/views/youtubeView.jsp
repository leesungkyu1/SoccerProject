<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

<%    
    request.setCharacterEncoding("UTF-8");
    String videoId = request.getParameter("videoId");
%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>TEST</h1>
	<!--IFrame API가 동영상 플레이어를 배치할 페이지의 위치를 식별 -->
	 <div id="player"></div>
	
	    <script>
	      // 2. 이 섹션의 코드는 Iframe Player API JavaScript 코드를 로드함
	      var tag = document.createElement('script');
	
	      tag.src = "https://www.youtube.com/iframe_api";
	      var firstScriptTag = document.getElementsByTagName('script')[0];
	      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
	
	      // 3. API코드가 다운되는 즉시 실행, 삽입한 동셩상 플레이어를 참조하는 전역변수 PLAYER를 정의하며,
	      //    함수가 동영상 플레이어 개체를 구성.
	      var player;
	      function onYouTubeIframeAPIReady() {
	        player = new YT.Player('player', {
	          height: '360',
	          width: '640',
	          videoId: <%= videoId %>,
	          events: {
	            'onReady': onPlayerReady,
	            'onStateChange': onPlayerStateChange
	          }
	        });
	      }
	
	      // 4.onReady 이벤트가 실행될 때 onPlayerReady 함수가 실행, 동셩상 플레이어가 준비되면 재생을 시작해야 함으로 나타냄.
	      function onPlayerReady(event) {
	        event.target.playVideo();
	      }
	
	      // 5. 플레이어의 상태 변경시 onPlayStateChange 함수를 호출, 플레이어 재생 중, 일시중지됨 및 완료됨을 나타냄.
	      //    함수는 플레이어 상태가 1(재생중)이면 6초를 재생한 후 stopVideo함수 호출하여 동영상을 중지.
	      var done = false;
	      function onPlayerStateChange(event) {
	        if (event.data == YT.PlayerState.PLAYING && !done) {
// 	          setTimeout(stopVideo, 6000);
	          done = true;
	        }
	      }
// 	      function stopVideo() {
// 	        player.stopVideo();
// 	      }
	      
	      // API의 JavaScript 코드가 로드된 후 API는 YT.Player 개체를 구성하여 
	      //페이지에 동영상 플레이어를 삽입할 수 있는 지점에서 onYouTbeIframeAPIReady 함수를 호출함
	      var player;
	      function onYouTubeIframeAPIReady() {
	        player = new YT.Player('player', {
	          height: '360',
	          width: '640',
	          videoId: '<%=videoId%>',
	          events: {
	            'onReady': onPlayerReady,
	            'onStateChange': onPlayerStateChange
	          }
	        });
	      }
	 </script>
	 
	 ${statistics }

</body>
</html>
 