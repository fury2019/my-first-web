package com.Hotel.vo;

public class HotelVO {
	private String hotel_id;
	private String hotel_name;
	private String hotel_addr;
	private String hotel_tel;  //호텔 전화번호
	private int hotel_grade;   //호텔등급
	private String hotel_lat;  //위도
	private String hotel_long; //경도
	private String hotel_tel2; //호텔예약전화번호
	private String hotel_resertime; //호텔 예약가능시간
	
	
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_addr() {
		return hotel_addr;
	}
	public void setHotel_addr(String hotel_addr) {
		this.hotel_addr = hotel_addr;
	}
	public String getHotel_tel() {
		return hotel_tel;
	}
	public void setHotel_tel(String hotel_tel) {
		this.hotel_tel = hotel_tel;
	}
	public int getHotel_grade() {
		return hotel_grade;
	}
	public void setHotel_grade(int hotel_grade) {
		this.hotel_grade = hotel_grade;
	}
	public String getHotel_lat() {
		return hotel_lat;
	}
	public void setHotel_lat(String hotel_lat) {
		this.hotel_lat = hotel_lat;
	}
	public String getHotel_long() {
		return hotel_long;
	}
	public void setHotel_long(String hotel_long) {
		this.hotel_long = hotel_long;
	}
	public String getHotel_tel2() {
		return hotel_tel2;
	}
	public void setHotel_tel2(String hotel_tel2) {
		this.hotel_tel2 = hotel_tel2;
	}
	public String getHotel_resertime() {
		return hotel_resertime;
	}
	public void setHotel_resertime(String hotel_resertime) {
		this.hotel_resertime = hotel_resertime;
	}
	
	@Override
	public String toString() {
		return "HotelVO [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_addr=" + hotel_addr
				+ ", hotel_tel=" + hotel_tel + ", hotel_grade=" + hotel_grade + ", hotel_lat=" + hotel_lat
				+ ", hotel_long=" + hotel_long + ", hotel_tel2=" + hotel_tel2 + ", hotel_resertime=" + hotel_resertime
				+ "]";
	}
	
}
