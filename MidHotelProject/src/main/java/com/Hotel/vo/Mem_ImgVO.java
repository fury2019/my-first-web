package com.Hotel.vo;

public class Mem_ImgVO {
	private String p_img_no;
	private String mem_id;
	private String p_img_name;
	private String p_img_org;
	
	public String getP_img_no() {
		return p_img_no;
	}
	public void setP_img_no(String p_img_no) {
		this.p_img_no = p_img_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getP_img_name() {
		return p_img_name;
	}
	public void setP_img_name(String p_img_name) {
		this.p_img_name = p_img_name;
	}
	public String getP_img_org() {
		return p_img_org;
	}
	public void setP_img_org(String p_img_org) {
		this.p_img_org = p_img_org;
	}
	
	@Override
	public String toString() {
		return "Mem_ImgVO [p_img_no=" + p_img_no + ", mem_id=" + mem_id + ", p_img_name=" + p_img_name + ", p_img_org="
				+ p_img_org + "]";
	}
	
}
