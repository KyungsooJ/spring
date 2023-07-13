<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>

<h3>${version }</h3>
<header>
	<h1><a href="${cpath }">board</a></h1>
	<nav>
		<ul>
			<li><a href="${cpath }/list">게시판 보기</a></li>
			<li><a href="${cpath }/add">추가</a></li>
		</ul>
	</nav>
</header>

<div id="list">
	<c:forEach var="dto" items=${list }>
	<div class="item">
		<div>${dto.title }</div>
		<div>${dto.content }</div>
		<div>${dto.writeDate }</div>
	</div>
	</c:forEach>
</div>

</body>
</html>