package com.ssafy.happyhouse.model.dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentDto {
	private int index;
	private String content;
	private String writer;
	private String time;
	private int articleIndex;
	
	public int getIndex() {
		return index;
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
	
	public String getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
	}
	
	public int getArticleIndex() {
		return articleIndex;
	}
	
	public void setArticleIndex(int articleIndex) {
		this.articleIndex = articleIndex;
	}
}