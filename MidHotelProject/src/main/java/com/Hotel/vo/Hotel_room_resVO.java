package com.Hotel.vo;

public class Hotel_room_resVO {
	String r_res_no;  
	String mem_id;  
	String type_name; 
	String hotel_id;  
	String r_res_chkindate;  
	String r_res_chkoutdate;  
	int r_res_price; 
	int r_res_adult;  
	int r_res_child;  
	int r_res_kids;  
	String room_no;  
	String room_status;
	
	private int roomCnt;
	
	
	String service_id;
	int addprice;
	int totalPrice;
	
	
	
	
	
	public String getService_id() {
		return service_id;
	}
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	public int getAddprice() {
		return addprice;
	}
	public void setAddprice(int addprice) {
		this.addprice = addprice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getRoomCnt() {
		return roomCnt;
	}
	public void setRoomCnt(int roomCnt) {
		this.roomCnt = roomCnt;
	}
	
	
	public String getR_res_no() {
		return r_res_no;
	}
	public void setR_res_no(String r_res_no) {
		this.r_res_no = r_res_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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
	public String getR_res_chkindate() {
		return r_res_chkindate;
	}
	public void setR_res_chkindate(String r_res_chkindate) {
		this.r_res_chkindate = r_res_chkindate;
	}
	public String getR_res_chkoutdate() {
		return r_res_chkoutdate;
	}
	public void setR_res_chkoutdate(String r_res_chkoutdate) {
		this.r_res_chkoutdate = r_res_chkoutdate;
	}
	public int getR_res_price() {
		return r_res_price;
	}
	public void setR_res_price(int r_res_price) {
		this.r_res_price = r_res_price;
	}
	public int getR_res_adult() {
		return r_res_adult;
	}
	public void setR_res_adult(int r_res_adult) {
		this.r_res_adult = r_res_adult;
	}
	public int getR_res_child() {
		return r_res_child;
	}
	public void setR_res_child(int r_res_child) {
		this.r_res_child = r_res_child;
	}
	public int getR_res_kids() {
		return r_res_kids;
	}
	public void setR_res_kids(int r_res_kids) {
		this.r_res_kids = r_res_kids;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getRoom_status() {
		return room_status;
	}
	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}
	@Override
	public String toString() {
		return "Hotel_room_resVO [r_res_no=" + r_res_no + ", mem_id=" + mem_id + ", type_name=" + type_name
				+ ", hotel_id=" + hotel_id + ", r_res_chkindate=" + r_res_chkindate + ", r_res_chkoutdate="
				+ r_res_chkoutdate + ", r_res_price=" + r_res_price + ", r_res_adult=" + r_res_adult + ", r_res_child="
				+ r_res_child + ", r_res_kids=" + r_res_kids + ", room_no=" + room_no + ", room_status=" + room_status
				+ ", roomCnt=" + roomCnt + ", service_id=" + service_id + ", addprice=" + addprice + ", totalPrice="
				+ totalPrice + "]";
	}
	
	
	

	
	
	
	
	
}
