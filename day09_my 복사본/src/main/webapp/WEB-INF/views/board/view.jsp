<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>게시판 읽기</h3>

<div id="boardView">
	
	<h3>${dto.idx } | ${dto.title } | <span id="writer">${dto.writer }</span></h3>
	<h4>조회수 : ${dto.viewCount }</h4>
	<h4>작성날짜 : <fmt:formatDate value="${dto.writeDate }"/></h4>
	<pre>${dto.content }</pre>
</div>

<div class="menubar">
	<div>
		<a href="${cpath }/board/write"><button>목록</button></a>
	</div>
	<div>
		<a href="${cpath }/board/modify/${dto.idx}"><button id="modifyBtn">수정</button></a>
		<a href="${cpath }/board/delete/${dto.idx}"><button id="deleteBtn">삭제</button></a>
	</div>
</div>

<script>
	const modifyBtn = document.getElementById('modifyBtn')
	const deleteBtn = document.getElementById('deleteBtn')
	const writer = document.getElementById('writer')
	const login = '${login.userid}'
	
	function loginCheck() {
		const flag = writer.innerText == login
		return flag
	}
	
	modifyBtn.onclick = function(event) {
		event.preventDefault()					// 1) 일단 이벤트의 기본작동을 막는다
		if(loginCheck() == false) {				// 2) 로그인 체크여부에 따라
			alert('본인의 글만 수정할 수 있습니다')		//		경고 메시지를 출력하고
			return								// 		함수를 종료한다
		}
		location.href = event.target.parentNode.href	// 3) 원래 이동하려던 주소로 이동시킨다
		// event : clickEvent
		// event.target : <button>
		// .parentNode : <a href="">
		// .href = "${cpath}/board/modify/{dto.idx}"
	}
	
	deleteBtn.onclick = function(event) {
		event.preventDefault()
		const check = loginCheck()
		if(check == false) {
			alert('본인의 글만 삭제할 수 있습니다')
			return
		}
		if(confirm('정말 삭제하시겠습니까')){
			location.href = event.target.parentNode.href			
		}
	}
</script>

</body>
</html>