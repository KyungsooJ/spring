<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day02</title>
<style>
	div.thumbnail > a > img {
		width: 250px;
	}
	.wrap {
		display: flex;
		flex-flow: wrap;		
		width: 900px;
		margin: auto;
	}
	.item {
		width: 300px;
	}
</style>
</head>
<body>

<h1>home.jsp</h1>
<hr>

<h3>DB Version : ${dbVersion }</h3>
<p>
	<a href="${cpath }/add"><button>영상 추가하기</button></a>
</p>

<div class="wrap">
	<c:forEach var="dto" items="${list }">
		<div class="item">
			<div>${dto.idx }</div>
			<div class="thumbnail">
				<a href="${cpath }/youtube/${dto.idx}"><img src="${dto.thumbnail }"></a>
			</div>
			<div>${dto.channel } | ${dto.title }</div>
		</div>
	</c:forEach>
</div>

</body>
</html>



