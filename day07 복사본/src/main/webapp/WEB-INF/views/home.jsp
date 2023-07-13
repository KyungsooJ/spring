<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main>
	<h3>대문페이지</h3>
	<h3>DB Version : ${version }</h3>
	
	<fieldset>
		<form method="POST" enctype="multipart/form-data" action="${cpath }/upload">
			<p><input name="title" placeholder="타이틀"></p>
			<p><input name="upload" type="file" multiple></p>
			<p><input type="submit"></p>
		</form>
	</fieldset>
	
	
	<div>
		<c:forEach var="dto" items="${list }">
		<div>
			<h3>
				${dto.idx} | 
				${dto.title } |  
				<a href="${cpath }/delete/${dto.idx}"><button>삭제</button></a>
			</h3>
			<c:forTokens var="filePath" items="${dto.filePath }" delims=",">
				<img src="${cpath}/upload/${filePath }" height="200">
			</c:forTokens>		
		</div>
		</c:forEach>
	</div>
	
</main>

</body>
</html>