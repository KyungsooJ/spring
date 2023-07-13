package com.itbank.model;

//	이름        널?       유형            
//	--------- -------- ------------- 
//	IDX       NOT NULL NUMBER        
//	TITLE     NOT NULL VARCHAR2(500) 
//	CHANNEL   NOT NULL VARCHAR2(100) 
//	THUMBNAIL NOT NULL VARCHAR2(500) 
//	IFRAME    NOT NULL VARCHAR2(500) 

public class YoutubeDTO {

	private int idx;
	private String title;
	private String channel;
	private String thumbnail;
	private String iframe;
	
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
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getIframe() {
		return iframe;
	}
	public void setIframe(String iframe) {
		this.iframe = iframe;
	}
	
	
}
