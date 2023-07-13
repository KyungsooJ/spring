<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<fieldset>
		<legend>회원가입</legend>
		
		<form method="POST">
			<p><input type="text" name="userId" placeholder="아이디" required autofocus></p>
			<p><input type="password" name="userPw" placeholder="비밀번호" required></p>
			<p><input type="text" name="userNick" placeholder="닉네임" required></p>
			<p><input type="submit" value="회원가입"></p>
		</form>
	</fieldset>
</body>
</html>