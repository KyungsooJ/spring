<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div>${dto.iframe }</div>
<hr>
<h3>${dto.title }</h3>
<h4>${dto.channel }</h4>

<div class="sb">
	<div>
		<button onclick="history.go(-1)">뒤로가기</button>
	</div>
	<div>
		<a href="${cpath }/modify/${dto.idx}"><button>수정</button></a>
		<a href="${cpath }/delete/${dto.idx}"><button>삭제</button></a>
	</div>
</div>

</body>
</html>