<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex06 - multiple 속성</h3>
<h4>컨트롤 키 혹은 마우스 드래그로 여러 파일을 선택합니다</h4>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="title" placeholder="타이틀"></p>
	<p><input type="file" name="upload" multiple></p>
	<p><input type="submit"></p>
</form>


</body>
</html>