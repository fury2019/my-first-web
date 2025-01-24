package com.shinnaHotel.DTO;

public class RoomDTO {

	private int r_id;			// 룸 넘버 ex)호수 번호 
	private String r_type;			// 룸 종류 ex) 스탠다드, 디럭스, 스위트, 로열
	private int r_capacity;		// 수용 인원
	private int r_price;		// 룸 가격
	private String r_img;			// 룸 이미지 저장을 위한 컬럼
	
	
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_type() {
		return r_type;
	}
	public void setR_type(String r_type) {
		this.r_type = r_type;
	}
	public int getR_capacity() {
		return r_capacity;
	}
	public void setR_capacity(int r_capacity) {
		this.r_capacity = r_capacity;
	}
	public int getR_price() {
		return r_price;
	}
	public void setR_price(int r_price) {
		this.r_price = r_price;
	}
	public String getR_img() {
		return r_img;
	}
	public void setR_img(String r_img) {
		this.r_img = r_img;
	}
	
	
	
}
