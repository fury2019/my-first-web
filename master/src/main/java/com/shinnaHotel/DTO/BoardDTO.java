package com.shinnaHotel.DTO;

import java.util.Date;

public class BoardDTO {

	private int b_number;			// 글 번호
	private String b_title;			// 글 제목
	private String b_writer;		// 작성자
	private String b_date;			// 작성일
	private String b_content;		// 글 내용
	private int b_readCnt;			// 조회수
	
	
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_readCnt() {
		return b_readCnt;
	}
	public void setB_readCnt(int b_readCnt) {
		this.b_readCnt = b_readCnt;
	}
	
	
	
	
	
	
	
	
	
}
