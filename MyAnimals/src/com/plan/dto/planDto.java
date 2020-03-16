package com.plan.dto;


public class planDto {
	
	private int center_seq;
	private String member_id;
	private String center_name;
	private String center_addr;
	private String center_phone;
	private String center_latitude;
	private String center_longitude;
	
	public planDto() {
		
	}

	public planDto(int center_seq, String member_id, String center_name, String center_addr, String center_phone,
			String center_latitude, String cneter_longitude) {
		super();
		this.center_seq = center_seq;
		this.member_id = member_id;
		this.center_name = center_name;
		this.center_addr = center_addr;
		this.center_phone = center_phone;
		this.center_latitude = center_latitude;
		this.center_longitude = cneter_longitude;
	}

	public int getCenter_seq() {
		return center_seq;
	}

	public void setCenter_seq(int center_seq) {
		this.center_seq = center_seq;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getCenter_name() {
		return center_name;
	}

	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}

	public String getCenter_addr() {
		return center_addr;
	}

	public void setCenter_addr(String center_addr) {
		this.center_addr = center_addr;
	}

	public String getCenter_phone() {
		return center_phone;
	}

	public void setCenter_phone(String center_phone) {
		this.center_phone = center_phone;
	}

	public String getCenter_latitude() {
		return center_latitude;
	}

	public void setCenter_latitude(String center_latitude) {
		this.center_latitude = center_latitude;
	}

	public String getCneter_longitude() {
		return center_longitude;
	}

	public void setCneter_longitude(String cneter_longitude) {
		this.center_longitude = cneter_longitude;
	}
	
	
	
	
}
