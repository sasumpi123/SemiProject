package com.calendar.dto;

import java.util.Date;

public class CalendarDto {
	
	private String member_id;
	private String volunteer_title;
	private String volunteer_content;
	private String volunteer_mdate;
	private int volunteer_seq;
	private String volunteer_regdate;
	
	
	public CalendarDto() {
		
	}


	public CalendarDto(String member_id, String volunteer_title, String volunteer_content, String volunteer_mdate,
			int volunteer_seq, String volunteer_regdate) {
		super();
		this.member_id = member_id;
		this.volunteer_title = volunteer_title;
		this.volunteer_content = volunteer_content;
		this.volunteer_mdate = volunteer_mdate;
		this.volunteer_seq = volunteer_seq;
		this.volunteer_regdate = volunteer_regdate;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getVolunteer_title() {
		return volunteer_title;
	}


	public void setVolunteer_title(String volunteer_title) {
		this.volunteer_title = volunteer_title;
	}


	public String getVolunteer_content() {
		return volunteer_content;
	}


	public void setVolunteer_content(String volunteer_content) {
		this.volunteer_content = volunteer_content;
	}


	public String getVolunteer_mdate() {
		return volunteer_mdate;
	}


	public void setVolunteer_mdate(String volunteer_mdate) {
		this.volunteer_mdate = volunteer_mdate;
	}


	public int getVolunteer_seq() {
		return volunteer_seq;
	}


	public void setVolunteer_seq(int volunteer_seq) {
		this.volunteer_seq = volunteer_seq;
	}


	public String getVolunteer_regdate() {
		return volunteer_regdate;
	}


	public void setVolunteer_regdate(String volunteer_regdate) {
		this.volunteer_regdate = volunteer_regdate;
	}
	
	
	
}
