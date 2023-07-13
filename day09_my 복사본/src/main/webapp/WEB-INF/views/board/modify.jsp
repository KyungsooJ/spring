<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>글 수정</h3>
<form method="POST">
	<p><input type="text" name="title" placeholder="제목" value="${dto.title }"></p>
	<p><input type="text" name="writer" value="${login.userid }" readonly></p>
	<p><textarea name="content" placeholder="내용" >${dto.content }</textarea></p>
	<p><input type="submit"></p>
</form>

</body>
</html>