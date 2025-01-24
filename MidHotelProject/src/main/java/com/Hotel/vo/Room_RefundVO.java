package com.Hotel.vo;

public class Room_RefundVO {

	private String room_res_no;
	private String refund_date;
	private int refund_price;
	private String refund_reason;
	
	public String getRoom_res_no() {
		return room_res_no;
	}
	public void setRoom_res_no(String room_res_no) {
		this.room_res_no = room_res_no;
	}
	public String getRefund_date() {
		return refund_date;
	}
	public void setRefund_date(String refund_date) {
		this.refund_date = refund_date;
	}
	public int getRefund_price() {
		return refund_price;
	}
	public void setRefund_price(int refund_price) {
		this.refund_price = refund_price;
	}
	public String getRefund_reason() {
		return refund_reason;
	}
	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}
	
	@Override
	public String toString() {
		return "Room_RefundVO [room_res_no=" + room_res_no + ", refund_date=" + refund_date + ", refund_price="
				+ refund_price + ", refund_reason=" + refund_reason + "]";
	}
	
}
