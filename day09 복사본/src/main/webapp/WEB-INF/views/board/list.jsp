<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>게시판</h3>

<div id="boardList">
	<div class="item columns">
		<div class="idx">번호</div>
		<div class="title">제목</div>
		<div class="writer">작성자</div>
		<div class="writeDate">작성일시</div>
		<div class="viewCount">조회수</div>
	</div>
	<c:forEach var="dto" items="${list }">
	<div class="item">
		<div class="idx">${dto.idx }</div>
		<div class="title">${dto.title }</div>
		<div class="writer">${dto.writer }</div>
		<div class="writeDate">${dto.writeDate }</div>
		<div class="viewCount">${dto.viewCount }</div>
	</div>
	</c:forEach>
</div>

<div class="menubar">
	<div>
	
	</div>
	<div>
		<a href="${cpath }/board/write"><button>새 글 작성</button></a>
	</div>
</div>


</body>
</html>