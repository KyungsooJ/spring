<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<fieldset>
	<legend>글 수정</legend>

	<form method="POST" enctype="multipart/form-data">
		<p>
			<input type="text" name="title" value="${dto.title }"
				placeholder="제목" required>
		</p>
		<p>
			<input type="file" name="upload" multiple>
		</p>
		<div>
			<div>현재 첨부파일 :</div>
			<c:if test="${empty dto.filePath }">
				<span>없음</span>
			</c:if>
			<c:if test="${not empty dto.filePath }">
				<c:forEach var="image" items="${dto.filePath }">
					<div>${image }</div>
				</c:forEach>
			</c:if>
			<div>
				<label><input type="checkbox" name="deleteFile">첨부파일
					삭제</label>
			</div>
		</div>
		<p>
			<textarea name="content">${dto.content }</textarea>
		</p>
		<p>
			<input type="text" name="writer" value="${login.userId }" readonly>
		</p>
		<p>
			<input type="submit" value="글 수정">
		</p>
	</form>
</fieldset>
</body>
</html>