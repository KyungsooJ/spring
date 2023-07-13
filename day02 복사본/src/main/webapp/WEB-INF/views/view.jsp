<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<div>${dto.iframe }</div>
	<h3>${dto.title }</h3>
	<h3>${dto.channel }</h3>
</div>

<p>
	<a href="${cpath }/delete/${dto.idx}"><button>삭제</button></a>
	<button onclick="history.go(-1)">뒤로가기</button>
</p>

</body>
</html>