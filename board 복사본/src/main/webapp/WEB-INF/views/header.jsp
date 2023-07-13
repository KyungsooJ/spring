<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 20px;
}

form {
	text-align: center;
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ccc;
}

th {
	background-color: #f2f2f2;
	font-weight: bold;
}

.item {
	margin-bottom: 20px;
}

.item:last-child {
	margin-bottom: 0;
}

.add {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.add input[type="text"] {
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.add input[type="submit"] {
  padding: 10px 20px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.add input[type="submit"]:hover {
  background-color: #45a049;
}


</style>
</head>
<body>

	<h3>${version }</h3>
	<header>
		<h1>
			<a href="${cpath }">board</a>
		</h1>
		<nav>
			<ul>
				<li><a href="${cpath }/list">게시판 보기</a></li>
			</ul>
		</nav>
	</header>

</body>
</html>