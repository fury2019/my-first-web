package com.Hotel.vo;

public class GoodsVO {
	private String goods_id;
	private String goods_name;
	private int goods_price;
	private String goods_cat_id;
	
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_cat_id() {
		return goods_cat_id;
	}
	public void setGoods_cat_id(String goods_cat_id) {
		this.goods_cat_id = goods_cat_id;
	}
	
	@Override
	public String toString() {
		return "GoodsVO [goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_price=" + goods_price
				+ ", goods_cat_id=" + goods_cat_id + "]";
	}
	
	
	
}
