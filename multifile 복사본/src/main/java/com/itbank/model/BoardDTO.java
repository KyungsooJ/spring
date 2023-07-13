package com.itbank.model;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

// board5
//이름        널?       유형             
//--------- -------- -------------- 
//IDX       NOT NULL NUMBER         
//TITLE     NOT NULL VARCHAR2(500)  
//CONTENT   NOT NULL VARCHAR2(3000) 
//WRITER    NOT NULL VARCHAR2(100)  
//WRITEDATE          DATE

// file5
//이름       널?       유형            
//-------- -------- ------------- 
//IDX      NOT NULL NUMBER        
//FILEPATH NOT NULL VARCHAR2(300) 
//BOARD    NOT NULL NUMBER        

public class BoardDTO {

	private int idx;
	private String title, content, writer;
	private Date writeDate;
	
	private List<MultipartFile> upload;
	private List<String> filePath;
	
	private String deleteFile;
	

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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public Date getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public List<MultipartFile> getUpload() {
		return upload;
	}


	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}


	public List<String> getFilePath() {
		return filePath;
	}


	public void setFilePath(List<String> filePath) {
		this.filePath = filePath;
	}


	public String getDeleteFile() {
		return deleteFile;
	}


	public void setDeleteFile(String deleteFile) {
		this.deleteFile = deleteFile;
	}

}
