<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<h3>게시판 : ${paging.page } / ${paging.pageCount }</h3>
<h3>${paging.begin }~ ${paging.end }</h3>

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
			<div class="title">
				<a href="${cpath }/board/view/${dto.idx}">${dto.title }</a>
			</div>
			<div class="writer">${dto.writer }</div>
			<div class="writeDate">${dto.writeDate }</div>
			<div class="viewCount">${dto.viewCount }</div>
		</div>
	</c:forEach>
</div>

<div class="menubar">
	<div>
		<form method="GET">
			<select name="column">
				<option value="title">제목</option>
				<option value="writer">작성자</option>
			</select>
			<input type="search" name="search" placeholder="검색어를 입력하세요">
			<input type="submit" value="검색">
		</form>
	</div>
	<div>
		<a href="${cpath }/board/write"><button>새 글 작성</button></a>
	</div>
</div>

<div class="paging">
	<c:if test="${paging.prev }">
		<a href="${cpath }/board?page=${paging.begin - paging.perPage}&column=${paging.column}&search=${paging.search}">[이전]</a>
	</c:if>
	
	<c:forEach var="i" begin="${paging.begin }" end="${paging.end }">
		<a href="${cpath }/board?page=${i}&column=${paging.column}&search=${paging.search}">[${i }]</a>
	</c:forEach>
	
	<c:if test="${paging.next }">
		<a href="${cpath }/board?page=${paging.end + 1}&column=${paging.column}&search=${paging.search}
		">[다음]</a>
	</c:if>
</div>
</body>
</html>