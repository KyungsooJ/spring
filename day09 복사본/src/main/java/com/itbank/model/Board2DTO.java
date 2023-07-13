package com.itbank.model;

import java.sql.Date;

//	idx         number          GENERATED AS IDENTITY primary key,
//	title       varchar2(100)   not null,
//	writer      varchar2(100)   not null,
//	content     varchar2(2000)  not null,
//	writeDate   date            default sysdate,
//	viewCount   number          default 0,

public class Board2DTO {
	private int idx;
	private String title;
	private String writer;
	private String content;
	private Date writeDate;
	private int viewCount;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
	
}
