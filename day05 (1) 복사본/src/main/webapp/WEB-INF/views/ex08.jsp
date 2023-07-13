<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>DB upload1 테이블에서 불러오기</h3>

<fieldset>
	<form method="POST" enctype="multipart/form-data">
		<p><input type="text" name="title" placeholder="타이틀"></p>
		<p><input type="file" name="upload"></p>
		<p><input type="submit"></p>
	</form>
</fieldset>

<div class="wrap">
	<c:forEach var="dto" items="${list }">
	<div class="item">
		<div><img src="${cpath }/upload/${dto.filePath}" width="200"></div>
		<div><h4>${dto.title }</h4></div>
	</div>
	</c:forEach>
</div>

</body>
</html>