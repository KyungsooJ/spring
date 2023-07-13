<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<table>
	<thead>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성날짜</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.idx }</td>
				<td><a href="${cpath }/board/view/${board.idx}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.writeDate }</td>
			</tr>

		</c:forEach>
	</tbody>
</table>
</body>
</html>