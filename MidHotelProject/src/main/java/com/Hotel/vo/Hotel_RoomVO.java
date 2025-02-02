package com.Hotel.vo;

public class Hotel_RoomVO {
	private String room_no;
	private String type_name;
	private String hotel_id;
	private String room_status;
	
	private int type_price;
	private int roomCnt; 
	
	
	
	
	public int getType_price() {
		return type_price;
	}
	public void setType_price(int type_price) {
		this.type_price = type_price;
	}
	public int getRoomCnt() {
		return roomCnt;
	}
	public void setRoomCnt(int roomCnt) {
		this.roomCnt = roomCnt;
	}
	
	
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
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
	public String getRoom_status() {
		return room_status;
	}
	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}
	
	@Override
	public String toString() {
		return "Hotel_RoomVO [room_no=" + room_no + ", type_name=" + type_name + ", hotel_id=" + hotel_id
				+ ", room_status=" + room_status + "]";
	}
	
	
}
