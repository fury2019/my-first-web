package com.shinnaHotel.DTO;

import java.util.Date;

public class ReservationDTO {

	private int res_number;			// 예약 번호
	private String u_id;			// 예약한 회원 아이디
	private int res_adults;			// 예약한 성인 수
	private int res_kids;			// 예약한 아동 수
	private String res_checkin;		// 체크인 날짜
	private String res_checkout;	// 체크아웃 날짜
	private String res_rtype;		// 예약한 룸 종류
	private int res_price;			// 가격
	private String res_time;		// 예약 일자
	private int r_id;				// 예약한 룸 호수
	private long diffday;			// 숙박일 수
	private int totalamount;		// 총 가격
	
	
	public int getRes_number() {
		return res_number;
	}
	public void setRes_number(int res_number) {
		this.res_number = res_number;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getRes_adults() {
		return res_adults;
	}
	public void setRes_adults(int res_adults) {
		this.res_adults = res_adults;
	}
	public int getRes_kids() {
		return res_kids;
	}
	public void setRes_kids(int res_kids) {
		this.res_kids = res_kids;
	}
	public String getRes_checkin() {
		return res_checkin;
	}
	public void setRes_checkin(String res_checkin) {
		this.res_checkin = res_checkin;
	}
	public String getRes_checkout() {
		return res_checkout;
	}
	public void setRes_checkout(String res_checkout) {
		this.res_checkout = res_checkout;
	}
	public String getRes_rtype() {
		return res_rtype;
	}
	public void setRes_rtype(String res_rtype) {
		this.res_rtype = res_rtype;
	}
	public int getRes_price() {
		return res_price;
	}
	public void setRes_price(int res_price) {
		this.res_price = res_price;
	}
	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public long getDiffday() {
		return diffday;
	}
	public void setDiffday(long diffday) {
		this.diffday = diffday;
	}
	public int getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	
	
	
	
	
}

