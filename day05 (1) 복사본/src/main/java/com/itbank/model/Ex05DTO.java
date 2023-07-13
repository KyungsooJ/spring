package com.itbank.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Ex05DTO {

	private String title;
	private List<MultipartFile> upload;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<MultipartFile> getUpload() {
		return upload;
	}
	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}
}
