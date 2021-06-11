<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
   src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.board {
   border: 1px solid black;
}

.imgBox{
   width:220px;
   height:220px;
}
.imgBox img{
   width:100%;
   height:100%;
}

</style>
<body>

	<h1>PLAYLIST TEST</h1>
   <div id="listDiv">   </div>
   <button onclick="test()">test</button>


</body>
<script>
var totaldata;
var items;
function test() {
   $.ajax({
      url : "/playlist.do",
      dataType : "text",
      contentType : "apllication/json",
      success : function(data) {
//     	console.log(asdf);
       	totaldata = JSON.parse(data);
       	console.log(totaldata);
       	dataMapping(totaldata);
      },
      error : function(XMLHttpRequest, textStatus, errorThrown) {
         alert("Status: " + textStatus);
         alert("Error" + errorThrown);
      }
   })
}

function dataMapping(totaldata) {

	items = totaldata.items;
   $("#listDiv").html("");
   var listDivHtml = "";
   for (var i = 0; i < items.length; i++) {
      listDivHtml += '<div class="boardmapper" onclick="goViewPage(\''+ items[i].snippet.resourceId.videoId + '\')">';
      listDivHtml += '   <span class="board">'+ items[i].snippet.resourceId.videoId + '</span>';
      listDivHtml += '   <span class="board">'+ items[i].snippet.title + '</span>';
      listDivHtml += '   <span class="board">'+ 
     				 		'<img src='+ items[i].snippet.thumbnails.default.url +'>'+ '</span>';
      listDivHtml += '</div>';
   }

   $("#listDiv").html(listDivHtml);
   
 

}

function goViewPage(videoId) {
	location.href="/view.do?videoId="+videoId;
	console.log(videoId);
}


</script>

</html>