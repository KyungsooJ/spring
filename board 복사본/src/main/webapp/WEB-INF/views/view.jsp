<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
    <tr>
        <th>닉네임</th>
        <td>${dto.nickName}</td>
    </tr>
    <tr>
        <th>제목</th>
        <td>${dto.title}</td>
    </tr>
    <tr>
        <th>내용</th>
        <td>${dto.content}</td>
    </tr>
</table>

<div class="sb">
    <div>
        <button onclick="history.go(-1)">뒤로가기</button>
    </div>
    <div>
        <a href="${cpath}/modify/${dto.idx}">수정</a>
        <a href="${cpath}/delete/${dto.idx}">삭제</a>
    </div>
</div>

</body>
</html>