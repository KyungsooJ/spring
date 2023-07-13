<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<fieldset>
	<legend>글 작성</legend>
	
 	<form method="POST" enctype="multipart/form-data">
		<p><input type="text" name="title" placeholder="제목" required></p>
		<p><input type="file" name="upload" multiple></p>
		<p><textarea name="content"></textarea></p>
		<p><input type="text" name="writer" value="${login.userId }" readonly></p>
		<p><input type="submit" value="글 작성"></p>
	</form>
</fieldset>
</body>
</html>