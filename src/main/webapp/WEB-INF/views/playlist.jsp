<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>목록페이지입니다</h1>

<div> 플레이리스트입니다. </div>
	<c:set var="dataList" value="${asdf}" />
    <c:forEach var="list" items="${dataList}">
			      <div class="title" >
				      <h3>${list.snippet }</h3>
				  </div>
	</c:forEach>
<a href = "/test">재생목록</a>
</body>
</html>