package com.alarm.dto;

public class AlarmDateDto {
	private String volunteer_title;
	private int volunteer_dayLeft;
	public String getVolunteer_title() {
		return volunteer_title;
	}
	public void setVolunteer_title(String volunteer_title) {
		this.volunteer_title = volunteer_title;
	}
	public int getVolunteer_dayLeft() {
		return volunteer_dayLeft;
	}
	public void setVolunteer_dayLeft(int volunteer_dayLeft) {
		this.volunteer_dayLeft = volunteer_dayLeft;
	}
	public AlarmDateDto(String volunteer_title, int volunteer_dayLeft) {
		super();
		this.volunteer_title = volunteer_title;
		this.volunteer_dayLeft = volunteer_dayLeft;
	}

	public AlarmDateDto() {}
	
}
