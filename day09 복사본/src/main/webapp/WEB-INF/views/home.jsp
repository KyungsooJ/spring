<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>version : ${version }</h3>
<h3>now : ${now }</h3>

<details>
	<summary>SQL</summary>
	<fieldset>
		<pre>
drop table member cascade constraints purge;

create table member (
    idx         number          GENERATED AS IDENTITY primary key,
    userid      varchar2(100)   unique not null,
    userpw      varchar2(255)   not null,
    username    varchar2(50)    not null,
    email       varchar2(100)   not null
);

select 
    idx, userid, username, email, userpw
        from member;
               
--------------------------------------------------------------------------------

drop table board2 purge;

create table board2 (
    idx         number          GENERATED AS IDENTITY primary key,
    title       varchar2(100)   not null,
    writer      varchar2(100)   not null,
    content     varchar2(2000)  not null,
    writeDate   date            default sysdate,
    viewCount   number          default 0,
    
    constraint board2_member_fk
    FOREIGN key (writer)
    REFERENCES member(userid)
    on delete set null
);

--------------------------------------------------------------------------------

drop table board2_file purge;
create table board2_file (
    idx         number          GENERATED AS IDENTITY primary key,
    board       number          not null,
    fileName    varchar2(255)   not null,
    
    constraint file_board2_fk
    FOREIGN key (board)
    REFERENCES board2(idx)
    on delete cascade
);


		
		</pre>
	</fieldset>
</details>


</body>
</html>