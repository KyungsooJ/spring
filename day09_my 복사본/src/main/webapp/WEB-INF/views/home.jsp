<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<h3>버전 : ${version }</h3>
<h3>
	시간 : ${now }
	<fmt:formatDate value="${now }" pattern="yyyy 년 MM 월 dd 일 a hh:mm:ss" />
</h3>
</body>
</html>