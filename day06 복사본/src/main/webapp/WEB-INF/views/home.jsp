<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>day06</h1>
<hr>

<h3>version : ${version }</h3>


<form method="POST" action="youtube_add">
	<p><input name="title" placeholder="제목"></p>
	<p><input name="channel" placeholder="채널"></p>
	<p><input name="thumbnail" placeholder="썸네일"></p>
	<p><input name="iframe" placeholder="영상 태그"></p>
	<p><input type="submit"></p>
</form>

</body>
</html>