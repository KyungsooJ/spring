<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day09</title>
<style>
	#loginInfo {
		text-align: right;
		padding-right: 20px;
		height: 25px;
	}
	#boardList {
		width: 900px;
		margin: 20px auto;
	}
	.item {
		display: flex;
		padding: 5px 10px;
	}
	.columns {
		background-color: #dadada;
	}
	.item > .idx,
	.item > .writer,
	.item > .writeDate,
	.item > .viewCount { 
		flex: 1; 
	}
	.item > .title {
		flex: 5;
	}
	.menubar {
		display: flex;
		width: 900px;
		margin: 20px auto;
		justify-content: space-between;
	}
	
</style>
</head>
<body>

<h1><a href="${cpath }">day09</a></h1>
<div id="loginInfo">
	<c:if test="${not empty login }">
		${login.userid } (${login.username })
	</c:if>
</div>
<nav>
	<ul>
		<li><a href="${cpath }/member/${empty login ? 'login' : 'logout'}">
			${empty login ? '로그인' : '로그아웃'}</a></li>
		<li><a href="${cpath }/board">게시판</a>
	</ul>
</nav>


