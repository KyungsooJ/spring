package com.itbank.model;

//IDX      NOT NULL NUMBER        
//USERID   NOT NULL VARCHAR2(100) 
//USERPW   NOT NULL VARCHAR2(300) 
//USERNICK NOT NULL VARCHAR2(300) 
public class MemberDTO {
	private int idx;
	private String userId, userPw, userNick;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	
	
}
