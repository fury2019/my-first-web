package com.Hotel.vo;

public class Hotel_EventVO {
	private String event_id;
	private String hotel_id;
	private String event_title;
	private String event_start;
	private String event_end;
	private String event_content;
	
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public String getEvent_start() {
		return event_start;
	}
	public void setEvent_start(String event_start) {
		this.event_start = event_start;
	}
	public String getEvent_end() {
		return event_end;
	}
	public void setEvent_end(String event_end) {
		this.event_end = event_end;
	}
	public String getEvent_content() {
		return event_content;
	}
	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}
	
	@Override
	public String toString() {
		return "Hotel_EventVO [event_id=" + event_id + ", hotel_id=" + hotel_id + ", event_title=" + event_title
				+ ", event_start=" + event_start + ", event_end=" + event_end + ", event_content=" + event_content
				+ "]";
	}
	
	
	
}
