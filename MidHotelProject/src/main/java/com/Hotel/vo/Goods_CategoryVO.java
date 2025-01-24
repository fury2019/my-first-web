package com.Hotel.vo;

public class Goods_CategoryVO {
	private String goods_cat_id;
	private String goods_cat_name;
	private String goods_cat_top_id;
	
	public String getGoods_cat_id() {
		return goods_cat_id;
	}
	public void setGoods_cat_id(String goods_cat_id) {
		this.goods_cat_id = goods_cat_id;
	}
	public String getGoods_cat_name() {
		return goods_cat_name;
	}
	public void setGoods_cat_name(String goods_cat_name) {
		this.goods_cat_name = goods_cat_name;
	}
	public String getGoods_cat_top_id() {
		return goods_cat_top_id;
	}
	public void setGoods_cat_top_id(String goods_cat_top_id) {
		this.goods_cat_top_id = goods_cat_top_id;
	}
	
	@Override
	public String toString() {
		return "Goods_CategoryVO [goods_cat_id=" + goods_cat_id + ", goods_cat_name=" + goods_cat_name
				+ ", goods_cat_top_id=" + goods_cat_top_id + "]";
	}
	
	
}
