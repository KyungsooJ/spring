<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h3>
	현재 날짜 및 시간 : 
	<fmt:formatDate value="${now }" pattern="yyyy년 MM월 dd일 a hh:mm:ss" />
</h3>


<fieldset>
	<legend>interceptor</legend>
	<ul>
		<li>요청을 가로채서 추가 공통 작업을 수행하는 객체</li>
		<li>컨트롤러에 요청이 도달하기 전에 수행하는 preHandle</li>
		<li>컨트롤러의 메서드가 수행되고 view로 포워드되기 전에 수행하는 postHandle</li>
		<li>view로 포워드되고 응답이 클라이언트로 출발한 후 수행하는 afterCompletion</li>
		<li>상속을 이용하여 구성하고, servlet-context.xml 에서 객체와 경로를 등록해야 한다</li>
	</ul>
</fieldset>
<br>

<fieldset>
	<legend>@ExceptionHandler</legend>
	<ul>
		<li>특정 타입의 예외가 발생하면, 예외 객체를 받아서 처리하는 함수</li>
		<li>예외 처리 구문 catch를 함수형태처럼 사용한다</li>
		<li>컨트롤러 내부에 배치하여 해당 컨트롤러 내부의 예외를 처리할 수 있다</li>
		<li>코드를 분리하기 위해 @ControllerAdvice 에 배치할 수도 있다</li>
	</ul>
</fieldset>
<br>

<fieldset>
	<legend>@ControllerAdvice</legend>
	<ul>
		<li>예외 처리 함수(ExceptionHandler)를 모아서 작성하는 클래스</li>
		<li>어노테이션에 assignableTypes 를 명시하여 특정 컨트롤러의 예외만 처리할 수 있다</li>
		<li>assignableTypes 를 명시하지 않으면, 전역 예외 처리기가 된다</li>
	</ul>
</fieldset>

</body>
</html>







