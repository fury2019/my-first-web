package com.Hotel.vo;

public class CouponVO {
	private String coupon_no;
	private String coupon_name;
	private String coupon_comment;
	private String coupon_condition;
	private String coupon_percent;
	private String mem_id;
	private String goods_cate_id;
	public String getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(String coupon_no) {
		this.coupon_no = coupon_no;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public String getCoupon_comment() {
		return coupon_comment;
	}
	public void setCoupon_comment(String coupon_comment) {
		this.coupon_comment = coupon_comment;
	}
	public String getCoupon_condition() {
		return coupon_condition;
	}
	public void setCoupon_condition(String coupon_condition) {
		this.coupon_condition = coupon_condition;
	}
	public String getCoupon_percent() {
		return coupon_percent;
	}
	public void setCoupon_percent(String coupon_percent) {
		this.coupon_percent = coupon_percent;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getGoods_cate_id() {
		return goods_cate_id;
	}
	public void setGoods_cate_id(String goods_cate_id) {
		this.goods_cate_id = goods_cate_id;
	}
	@Override
	public String toString() {
		return "CouponVO [coupon_no=" + coupon_no + ", coupon_name=" + coupon_name + ", coupon_comment="
				+ coupon_comment + ", coupon_condition=" + coupon_condition + ", coupon_percent=" + coupon_percent
				+ ", mem_id=" + mem_id + ", goods_cate_id=" + goods_cate_id + "]";
	}
	
	
}
