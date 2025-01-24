package com.Hotel.vo;

public class MemberVO {
	private String mem_id;
	private String mem_name;
	private String mem_pw;
	private String mem_bir;
	private String mem_gender;
	private String mem_tel;
	private String mem_post;
	private String mem_addr1;
	private String mem_addr2;
	private String mem_create;
	private int mem_point;
	private String grade_no;
	
	
	private String grade_name;
	private int grade_point;
	private int grade_ed;
	private String grade_rood;
	private String grade_chkout;
	
//	private int addPoint;
//	
//	
//	public int getAddPoint() {
//		return addPoint;
//	}
//	public void setAddPoint(int addPoint) {
//		this.addPoint = addPoint;
//	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public int getGrade_point() {
		return grade_point;
	}
	public void setGrade_point(int grade_point) {
		this.grade_point = grade_point;
	}
	public int getGrade_ed() {
		return grade_ed;
	}
	public void setGrade_ed(int grade_ed) {
		this.grade_ed = grade_ed;
	}
	public String getGrade_rood() {
		return grade_rood;
	}
	public void setGrade_rood(String grade_rood) {
		this.grade_rood = grade_rood;
	}
	public String getGrade_chkout() {
		return grade_chkout;
	}
	public void setGrade_chkout(String grade_chkout) {
		this.grade_chkout = grade_chkout;
	}
	
	
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(String mem_bir) {
		this.mem_bir = mem_bir;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_post() {
		return mem_post;
	}
	public void setMem_post(String mem_post) {
		this.mem_post = mem_post;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_create() {
		return mem_create;
	}
	public void setMem_create(String mem_create) {
		this.mem_create = mem_create;
	}
	public int getMem_point() {
		return mem_point;
	}
	public void setMem_point(int mem_point) {
		this.mem_point = mem_point;
	}
	public String getGrade_no() {
		return grade_no;
	}
	public void setGrade_no(String grade_no) {
		this.grade_no = grade_no;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_pw=" + mem_pw + ", mem_bir=" + mem_bir
				+ ", mem_gender=" + mem_gender + ", mem_tel=" + mem_tel + ", mem_post=" + mem_post + ", mem_addr1="
				+ mem_addr1 + ", mem_addr2=" + mem_addr2 + ", mem_create=" + mem_create + ", mem_point=" + mem_point
				+ ", grade_no=" + grade_no + "]";
	}
	
	
}
