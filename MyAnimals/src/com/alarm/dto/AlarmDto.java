package com.alarm.dto;

public class AlarmDto {
	private String volunteer_date;
	private String volunteer_title;
	public String getVolunteer_date() {
		return volunteer_date;
	}
	public void setVolunteer_date(String volunteer_date) {
		this.volunteer_date = volunteer_date;
	}
	public String getVolunteer_title() {
		return volunteer_title;
	}
	public void setVolunteer_title(String volunteer_title) {
		this.volunteer_title = volunteer_title;
	}
	public AlarmDto(String volunteer_date, String volunteer_title) {
		super();
		this.volunteer_date = volunteer_date;
		this.volunteer_title = volunteer_title;
	}
	public AlarmDto() {}
}
