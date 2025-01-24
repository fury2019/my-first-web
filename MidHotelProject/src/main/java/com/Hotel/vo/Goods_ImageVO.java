package com.Hotel.vo;

public class Goods_ImageVO {
	private String goods_img_no;
	private String goods_id;
	private String goods_img_name;
	private String goods_img_org;
	
	public String getGoods_img_no() {
		return goods_img_no;
	}
	public void setGoods_img_no(String goods_img_no) {
		this.goods_img_no = goods_img_no;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_img_name() {
		return goods_img_name;
	}
	public void setGoods_img_name(String goods_img_name) {
		this.goods_img_name = goods_img_name;
	}
	public String getGoods_img_org() {
		return goods_img_org;
	}
	public void setGoods_img_org(String goods_img_org) {
		this.goods_img_org = goods_img_org;
	}
	
	@Override
	public String toString() {
		return "Goods_ImageVO [goods_img_no=" + goods_img_no + ", goods_id=" + goods_id + ", goods_img_name="
				+ goods_img_name + ", goods_img_org=" + goods_img_org + "]";
	}
	
	
}
