package com.ssafy.happyhouse.model.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticleDto {
	private int index;
	private String title;
	private String content;
	private String writer;
	private String time;
	private String board;
	
	public int getIndex() {
		return index;
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
	
	public String getTime() throws ParseException {
		return this.time;
	}
	
	public void setTime(Date time) {
		this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
	}
	
	public String getBoard() {
		return board;
	}
	
	public void setBoard(String board) {
		this.board = board;
	}
}