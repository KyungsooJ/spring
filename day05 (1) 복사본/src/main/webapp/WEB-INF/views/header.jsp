<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day05</title>
<style>
	.wrap {
		display: flex;
		flex-flow: wrap;
		width: 900px;
		margin: 30px auto;
	}
	.item {
		width: 250px;
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		align-items: center;
	}
</style>
</head>
<body>
<h1><a href="${cpath }">day05</a></h1>
