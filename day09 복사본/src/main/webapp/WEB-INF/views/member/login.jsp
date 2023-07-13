<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>로그인</h3>

<div>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID"></p>
		<p><input type="password" name="userpw" placeholder="Password"></p>
		<p><input type="submit"></p>
	</form>
	<p>
		<a href="${cpath }/member/join">아직 회원이 아니십니까</a>
	</p>
</div>



</body>
</html>