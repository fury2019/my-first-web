package com.shinnaHotel.DTO;

import java.util.Date;

public class CommentDTO {

	
	private int b_number;			// 댓글이 달린 글 번호
	private int c_number;			// 댓글 번호
	private String c_comment;		// 댓글 내용
	private String c_date;			// 댓글 작성 시간
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public int getC_number() {
		return c_number;
	}
	public void setC_number(int c_number) {
		this.c_number = c_number;
	}
	public String getC_comment() {
		return c_comment;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
