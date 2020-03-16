package com.calendar.dto;

public class ApplyDto {
	
	private int apply_seq;
	private int volunteer_seq;
	private String member_id;
	private String apply_phone;
	private String apply_name;
	private String apply_email;
	
	public ApplyDto() {
		
	}

	public ApplyDto(int apply_seq, int volunteer_seq, String member_id, String apply_phone, String apply_name,
			String apply_email) {
		super();
		this.apply_seq = apply_seq;
		this.volunteer_seq = volunteer_seq;
		this.member_id = member_id;
		this.apply_phone = apply_phone;
		this.apply_name = apply_name;
		this.apply_email = apply_email;
	}

	public int getApply_seq() {
		return apply_seq;
	}

	public void setApply_seq(int apply_seq) {
		this.apply_seq = apply_seq;
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

	public String getApply_phone() {
		return apply_phone;
	}

	public void setApply_phone(String apply_phone) {
		this.apply_phone = apply_phone;
	}

	public String getApply_name() {
		return apply_name;
	}

	public void setApply_name(String apply_name) {
		this.apply_name = apply_name;
	}

	public String getApply_email() {
		return apply_email;
	}

	public void setApply_email(String apply_email) {
		this.apply_email = apply_email;
	}
	

}
