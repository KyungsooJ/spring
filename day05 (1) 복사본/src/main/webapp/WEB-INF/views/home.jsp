<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<ul>
	<li><a href="${cpath }/ex01">ex01 - MultipartRequest</a></li>
	<li><a href="${cpath }/ex02">ex02 - MultipartFile</a></li>
	<li><a href="${cpath }/ex03">ex03 - 커맨드 객체 (파일 포함)</a></li>
	<li><a href="${cpath }/ex04">ex04 - 업로드 파일 불러오기 (servlet-context.xml (resources))</a></li>
	<li><a href="${cpath }/ex05">ex05 - 여러 파일 업로드 (분리된 input)</a></li>
	<li><a href="${cpath }/ex06">ex06 - 여러 파일 업로드 (multiple)</a></li>
	<li><a href="${cpath }/ex07">ex07 - 여러 파일 업로드 (webkitdirectory)</a></li>
	<li><a href="${cpath }/ex08">ex08 - DB에 저장된 내용 불러오기 (단일 파일)</a></li>
</ul>


<details>
	<summary>upload1</summary>
	<fieldset>
		<pre>
drop table upload1 purge;

create table upload1 (
    idx         int             generated always as identity primary key,
    title       varchar2(100)   not null,
    filePath    varchar2(255)   not null
);

insert into upload1 (title, filePath) values ('홍진호', '11.jpg');
insert into upload1 (title, filePath) values ('맹구', '맹구.png');
insert into upload1 (title, filePath) values ('지수', 'jisoo.jpg');

commit;

select * from upload1 order by idx;
		</pre>
	
	</fieldset>
</details>

</body>
</html>