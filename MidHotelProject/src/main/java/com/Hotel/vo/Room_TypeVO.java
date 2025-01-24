package com.Hotel.vo;

public class Room_TypeVO {

	private String type_name;
	private String hotel_id;
	private int offs_price;
	private int type_price;
	private int peaks_price;
	private String type_content;
	
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public int getOffs_price() {
		return offs_price;
	}
	public void setOffs_price(int offs_price) {
		this.offs_price = offs_price;
	}
	public int getType_price() {
		return type_price;
	}
	public void setType_price(int type_price) {
		this.type_price = type_price;
	}
	public int getPeaks_price() {
		return peaks_price;
	}
	public void setPeaks_price(int peaks_price) {
		this.peaks_price = peaks_price;
	}
	public String getType_content() {
		return type_content;
	}
	public void setType_content(String type_content) {
		this.type_content = type_content;
	}
	
	@Override
	public String toString() {
		return "Room_typeVO [type_name=" + type_name + ", hotel_id=" + hotel_id + ", offs_price=" + offs_price
				+ ", type_price=" + type_price + ", peaks_price=" + peaks_price + ", type_content=" + type_content
				+ "]";
	}
	
	
}
