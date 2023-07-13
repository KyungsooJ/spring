<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<form method="GET" action="${cpath }/searchList">
    <p align="center">
        <input type="search" name="search" placeholder="제목으로 검색하세요" value="${param.search }">
        <input type="submit" value="검색">
    </p>
</form>

<button onclick="location.href='${cpath}/add';">추가</button>

<table id="list">
    <tr>
        <th>닉네임</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성일</th>
    </tr>
    <c:forEach var="dto" items="${list}">
        <tr class="item">
            <td>${dto.nickName}</td>
            <td>
                <a href="${cpath}/view/${dto.idx}">
                ${dto.title}</a>
            </td>
            <td>${dto.content}</td>
            <td>${dto.writeDate}</td>
        </tr>
        <%-- <div>
            <a href="${cpath}/modify/${dto.idx}"><button>수정</button></a>
            <a href="${cpath}/delete/${dto.idx}"><button>삭제</button></a>
        </div> --%>
    </c:forEach>
</table>

</body>
</html>
