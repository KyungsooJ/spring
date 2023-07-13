<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<style>
	img {
		width: 250px;
		height: 250px;
	}
</style>
</head>
<body>
<header>
	<h1>Board</h1>
	<ul>
		<c:if test="${empty login }">
			<li><a href="${cpath }/member/login">로그인</a></li>
			<li><a href="${cpath }/member/join">회원가입</a></li>		
		</c:if>
		<c:if test="${not empty login }">
			<li><a href="${cpath }/member/logout">로그아웃</a></li>
			<li><a href="${cpath }/board/list">리스트</a></li>
			<li><a href="${cpath }/board/add">글 작성</a></li>
		</c:if>
	</ul>
	<hr>
</header>
</body>
</html>