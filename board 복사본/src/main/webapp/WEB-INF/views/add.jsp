<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>게시글 추가하기</h3>
<hr>

<form method="POST" class="add">
	<div class="nickName"><input type="text" name="nickName" placeholder="닉네임"></div>
	<div class="title"><input type="text" name="title" placeholder="제목"></div>
	<div class="content"><input type="text" name="content" placeholder="내용"></div>
	<div class="submit"><input type="submit"></div>
</form>

</body>
</html>