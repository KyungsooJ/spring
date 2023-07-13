<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day08</title>
</head>
<body>
<h1><a href="${cpath }">day08</a></h1>

<p align="right">
	<c:if test="${not empty login }">현재 사용자 : ${login.userid }</c:if>
</p>
<nav>
	<ul>
		<c:if test="${empty login }">
			<li><a href="${cpath }/member/login">로그인</a></li>
		</c:if>
		<c:if test="${not empty login }">
			<li><a href="${cpath }/member/logout">로그아웃</a></li>
		</c:if>
		<li><a href="${cpath }/board">게시판 (회원전용)</a></li>
		<li><a href="${cpath }/youtube_list">유튜브 영상 클립 (회원전용)</a></li>
		<li><a href="${cpath }/upload2">그림 파일 갤러리</a></li>
	</ul>
</nav>


<hr>



