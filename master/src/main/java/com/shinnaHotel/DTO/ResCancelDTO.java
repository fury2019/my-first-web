package com.shinnaHotel.DTO;

import java.util.Date;

import oracle.sql.DATE;

public class ResCancelDTO {
	private int res_number;
	private String u_id;
	private String res_checkin;
	private String res_checkout;
	private String res_rtype;
	private int res_price;
	private String cancel_date;
	
	
	public int getRes_number() {
		return res_number;
	}
	public void setRes_number(int res_number) {
		this.res_number = res_number;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getRes_checkin() {
		return res_checkin;
	}
	public void setRes_checkin(String res_checkin) {
		this.res_checkin = res_checkin;
	}
	public String getRes_checkout() {
		return res_checkout;
	}
	public void setRes_checkout(String res_checkout) {
		this.res_checkout = res_checkout;
	}
	public String getRes_rtype() {
		return res_rtype;
	}
	public void setRes_rtype(String res_rtype) {
		this.res_rtype = res_rtype;
	}
	public int getRes_price() {
		return res_price;
	}
	public void setRes_price(int res_price) {
		this.res_price = res_price;
	}
	public String getCancel_date() {
		return cancel_date;
	}
	public void setCancel_date(String cancel_date) {
		this.cancel_date = cancel_date;
	}
	
	
	
}
