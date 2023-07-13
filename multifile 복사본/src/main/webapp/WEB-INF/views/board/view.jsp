<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	<div>
		<div>${dto.idx}, ${dto.title }</div>
		<div>${dto.writer } | ${dto.writeDate }</div>
		<div>
			<c:forEach var="image" items="${dto.filePath }">
				<img src="${cpath }/upload/${image}">
			</c:forEach>
		</div>
		<pre>${dto.content }</pre>
	</div>
	
	<p>
		<a href="${cpath }/board/modify/${dto.idx}"><button>수정</button></a>
		<a href="${cpath }/board/delete/${dto.idx}"><button>삭제</button></a>
	</p>
</body>
</html>