package com.calendar.dto;

public class VolunteerDto {
	
	private int volunteer_seq;
	private String member_id;
	private String volunteer_title;
	private String volunteer_content;
	private int volunteer_maxvolunteer;
	private int volunteer_nowvolunteer;
	private String volunteer_date;
	private int center_seq;
	
	public VolunteerDto() {
		
	}

	

	public VolunteerDto(int volunteer_seq, String member_id, String volunteer_title, String volunteer_content,
			int volunteer_maxvolunteer, int volunteer_nowvolunteer, String volunteer_date, int center_seq) {
		super();
		this.volunteer_seq = volunteer_seq;
		this.member_id = member_id;
		this.volunteer_title = volunteer_title;
		this.volunteer_content = volunteer_content;
		this.volunteer_maxvolunteer = volunteer_maxvolunteer;
		this.volunteer_nowvolunteer = volunteer_nowvolunteer;
		this.volunteer_date = volunteer_date;
		this.center_seq = center_seq;
	}

	

	public int getCenter_seq() {
		return center_seq;
	}



	public void setCenter_seq(int center_seq) {
		this.center_seq = center_seq;
	}



	public int getVolunteer_seq() {
		return volunteer_seq;
	}

	public void setVolunteer_seq(int volunteer_seq) {
		this.volunteer_seq = volunteer_seq;
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

	public int getVolunteer_maxvolunteer() {
		return volunteer_maxvolunteer;
	}

	public void setVolunteer_maxvolunteer(int volunteer_maxvolunteer) {
		this.volunteer_maxvolunteer = volunteer_maxvolunteer;
	}

	public int getVolunteer_nowvolunteer() {
		return volunteer_nowvolunteer;
	}

	public void setVlounteer_nowvolunteer(int vlounteer_nowvolunteer) {
		this.volunteer_nowvolunteer = vlounteer_nowvolunteer;
	}

	public String getVolunteer_date() {
		return volunteer_date;
	}

	public void setVolunteer_date(String volunteer_date) {
		this.volunteer_date = volunteer_date;
	}
	
	

}
