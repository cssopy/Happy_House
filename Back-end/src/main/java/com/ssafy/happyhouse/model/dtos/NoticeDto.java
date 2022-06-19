package com.ssafy.happyhouse.model.dtos;

public class NoticeDto {
	//idx는 auto increment
	private int idx;
	private String title;
	private String contents;
	private String date;
	public String getTitle() {
		return title;
	}
	
	public NoticeDto() {}
	
	public NoticeDto(String title, String contents, String date) {
		super();
		this.title = title;
		this.contents = contents;
		this.date = date;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public void setIdx(int index) {
		this.idx = index;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}
