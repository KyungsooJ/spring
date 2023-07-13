<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex07 - 폴더 업로드</h3>
<h4>폴더 내부 파일을 모두 업로드 하기</h4>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="title" placeholder="타이틀"></p>
	<p><input type="file" name="upload" webkitdirectory></p>
	<p><input type="submit"></p>
</form>


</body>
</html>