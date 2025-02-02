package com.Hotel.vo;


public class Room_ReservationVO {

	private String r_res_no;
	private String mem_id;
	private String room_no;
	private String type_name;
	private String hotel_id;
	private String hotel_name;
	private String r_res_chkindate;
	private String r_res_chkoutdate;
	private int r_res_price;
	private int r_res_adult;
	private int r_res_child;
	private int r_res_kids;
	
	private String service_id;
	private int add_price;
	private int total_add_price;
	
		private int sum_price;
	
	
	
	public String getService_id() {
		return service_id;
	}
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	public int getAdd_price() {
		return add_price;
	}
	public void setAdd_price(int add_price) {
		this.add_price = add_price;
	}
	public int getTotal_add_price() {
		return total_add_price;
	}
	public void setTotal_add_price(int total_add_price) {
		this.total_add_price = total_add_price;
	}
	public int getSum_price() {
		return sum_price;
	}
	public void setSum_price(int sum_price) {
		this.sum_price = sum_price;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
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
	@Override
	public String toString() {
		return "Room_ReservationVO [r_res_no=" + r_res_no + ", mem_id=" + mem_id + ", room_no=" + room_no
				+ ", type_name=" + type_name + ", hotel_id=" + hotel_id + ", r_res_chkindate=" + r_res_chkindate
				+ ", r_res_chkoutdate=" + r_res_chkoutdate + ", r_res_price=" + r_res_price + ", r_res_adult="
				+ r_res_adult + ", r_res_child=" + r_res_child + ", r_res_kids=" + r_res_kids + "]";
	}
	
	
	
	
	
	
}
