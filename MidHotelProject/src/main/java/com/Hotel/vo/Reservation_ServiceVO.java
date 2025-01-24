package com.Hotel.vo;

public class Reservation_ServiceVO {
	
	private String service_id;
	private String r_res_no;
	
	public String getService_id() {
		return service_id;
	}
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	public String getR_res_no() {
		return r_res_no;
	}
	public void setR_res_no(String r_res_no) {
		this.r_res_no = r_res_no;
	}
	
	@Override
	public String toString() {
		return "Reservation_ServiceVO [service_id=" + service_id + ", r_res_no=" + r_res_no + "]";
	}
	
	
	
}
