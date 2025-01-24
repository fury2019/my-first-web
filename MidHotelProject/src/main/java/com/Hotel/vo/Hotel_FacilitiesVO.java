package com.Hotel.vo;

public class Hotel_FacilitiesVO {
	private String fac_id;
	private String hotel_id;
	private String fac_cat_id;
	private String fac_name;
	private String fac_runtime;
	private int fac_max_mem;
	private String fac_status;
	private String fac_content;
	
	public String getFac_id() {
		return fac_id;
	}
	public void setFac_id(String fac_id) {
		this.fac_id = fac_id;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getFac_cat_id() {
		return fac_cat_id;
	}
	public void setFac_cat_id(String fac_cat_id) {
		this.fac_cat_id = fac_cat_id;
	}
	public String getFac_name() {
		return fac_name;
	}
	public void setFac_name(String fac_name) {
		this.fac_name = fac_name;
	}
	public String getFac_runtime() {
		return fac_runtime;
	}
	public void setFac_runtime(String fac_runtime) {
		this.fac_runtime = fac_runtime;
	}
	public int getFac_max_mem() {
		return fac_max_mem;
	}
	public void setFac_max_mem(int fac_max_mem) {
		this.fac_max_mem = fac_max_mem;
	}
	public String getFac_status() {
		return fac_status;
	}
	public void setFac_status(String fac_status) {
		this.fac_status = fac_status;
	}
	public String getFac_content() {
		return fac_content;
	}
	public void setFac_content(String fac_content) {
		this.fac_content = fac_content;
	}
	
	@Override
	public String toString() {
		return "Hotel_FacilitiesVO [fac_id=" + fac_id + ", hotel_id=" + hotel_id + ", fac_cat_id=" + fac_cat_id
				+ ", fac_name=" + fac_name + ", fac_runtime=" + fac_runtime + ", fac_max_mem=" + fac_max_mem
				+ ", fac_status=" + fac_status + ", fac_content=" + fac_content + "]";
	}
	
	
	
}
