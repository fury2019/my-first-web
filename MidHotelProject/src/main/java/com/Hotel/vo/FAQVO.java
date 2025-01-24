package com.Hotel.vo;

public class FAQVO {
	private String faq_no;
	private String faq_title;
	private String faq_content;
	private String class_id;
	public String getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(String faq_no) {
		this.faq_no = faq_no;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	
	@Override
	public String toString() {
		return "FAQVO [faq_no=" + faq_no + ", faq_title=" + faq_title + ", faq_content=" + faq_content + ", class_id="
				+ class_id + "]";
	}

}


	