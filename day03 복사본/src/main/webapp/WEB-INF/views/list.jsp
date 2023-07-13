<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="GET" action="${cpath }/searchList">
	<p align="center">
		<input type="search" name="search" placeholder="검색어를 입력하세요" value="${param.search }">
		<input type="submit" value="검색">
	</p>
</form>

<div id="list">
	<c:forEach var="dto" items="${list }">
	<div class="item">
		<div>
			<a href="${cpath }/view/${dto.idx}">
				<img src="${dto.thumbnail }">
			</a>
		</div>
		<div>${dto.title }</div>
		<div>${dto.channel }</div>
	</div>
	</c:forEach>
</div>

</body>
</html>