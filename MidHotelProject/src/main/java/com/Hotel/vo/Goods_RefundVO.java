package com.Hotel.vo;

public class Goods_RefundVO {
	private String pay_id;
	private String refund_date;
	private int refund_price;
	private String refund_reason;
	
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
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
		return "Goods_RefundVO [pay_id=" + pay_id + ", refund_date=" + refund_date + ", refund_price=" + refund_price
				+ ", refund_reason=" + refund_reason + "]";
	}
	
	
}
