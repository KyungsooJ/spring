<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="${cpath }/resources/js/script.js"></script>

<h3>수정</h3>
<hr>

<form method="POST">
	<p><input type="text" name="title" placeholder="영상 제목" value="${dto.title }"></p>
	<p><input type="text" name="channel" placeholder="채널 이름" value="${dto.channel }"></p>
	<p><input type="text" name="thumbnail" placeholder="썸네일 경로" value="${dto.thumbnail }"></p>
	<p>
		<textarea name="iframe">${dto.iframe }</textarea>
	</p>
	<p>
		<input type="submit">
		<input type="button" name="resize" value="영상 크기 조정">
	</p>
</form>

<script>
	const btn = document.querySelector('input[name="resize"]')
	btn.onclick = resizeHandler
</script>











</body>
</html>