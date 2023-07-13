<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day03</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">
</head>
<body>

<header>
	<h1><a href="${cpath }">day03</a></h1>
	<nav>
		<ul>
			<li><a href="${cpath }/list">목록</a></li>
			<li><a href="${cpath }/add">추가</a></li>
		</ul>
	</nav>
</header>



