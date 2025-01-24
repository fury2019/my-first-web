package com.Hotel.vo;

public class InquiryVO {
	private String inq_no;
	private String inq_title;
	private String inq_content;
	private String mem_id;
	private String class_id;
	
	public String getInq_no() {
		return inq_no;
	}
	public void setInq_no(String inq_no) {
		this.inq_no = inq_no;
	}
	public String getInq_title() {
		return inq_title;
	}
	public void setInq_title(String inq_title) {
		this.inq_title = inq_title;
	}
	public String getInq_content() {
		return inq_content;
	}
	public void setInq_content(String inq_content) {
		this.inq_content = inq_content;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	
	@Override
	public String toString() {
		return "InquiryVO [inq_no=" + inq_no + ", inq_title=" + inq_title + ", inq_content=" + inq_content + ", mem_id="
				+ mem_id + ", class_id=" + class_id + "]";
	}
	
	
}
