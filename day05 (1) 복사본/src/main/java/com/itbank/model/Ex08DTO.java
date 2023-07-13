package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

//	create table upload1 (
//	    idx         int             generated always as identity primary key,
//	    title       varchar2(100)   not null,
//	    filePath    varchar2(255)   not null
//	);

public class Ex08DTO {
	private int idx;
	private String title;
	
	private String filePath;		// DB에 저장된 파일 경로를 문자열로 받아오기 위한 필드
	private MultipartFile upload;	// <form>으로 전송되는 파일을 저장하기 위한 필드
	
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	
}
