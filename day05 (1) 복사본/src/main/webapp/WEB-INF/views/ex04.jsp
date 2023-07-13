<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex04 - 업로드한 파일의 목록</h3>

<c:forEach var="txt" items="${list }">
	<p>
		${txt }
		<img src="${cpath }/upload/${txt }" height="150">
	</p>
</c:forEach>

</body>
</html>