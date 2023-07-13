package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

public class Ex03DTO {

	private String name;
	private int age;
	private MultipartFile upload;
	
	@Override
	public String toString() {
		String form = "%s, %d살, %s (%s byte)";
		form = String.format(form, name, age, upload.getOriginalFilename(), upload.getSize());
		return form;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	
}
