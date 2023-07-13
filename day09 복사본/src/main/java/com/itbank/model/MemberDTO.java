package com.itbank.model;

//	create table member (
//	    idx         number          GENERATED AS IDENTITY,
//	    userid      varchar2(100)   unique not null,
//	    userpw      varchar2(255)   not null,
//	    username    varchar2(50)    not null,
//	    email       varchar2(100)   not null
//	);

public class MemberDTO {
	private int idx;
	private String userid;
	private String userpw;
	private String username;
	private String email;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
