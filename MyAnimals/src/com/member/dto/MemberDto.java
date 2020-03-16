package com.member.dto;

import java.util.Date;

public class MemberDto {
	private String member_id;
	private String member_pw;
	private String member_name;
	private int member_birth;
	private String member_email;
	private String member_gender;
	private String member_address;
	private String member_role;
	private String member_delflag;
	private Date member_regdate;
	private String member_phone;
	private String member_nickname;
	
	
	public MemberDto() {

	}
	
	
	public MemberDto(String member_id, String member_pw, String member_name, int member_birth, String member_email,
			String member_gender, String member_address, String member_role, String member_delflag, Date member_regdate,
			String member_phone, String member_nickname) {

		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_birth = member_birth;
		this.member_email = member_email;
		this.member_gender = member_gender;
		this.member_address = member_address;
		this.member_role = member_role;
		this.member_delflag = member_delflag;
		this.member_regdate = member_regdate;
		this.member_phone = member_phone;
		this.member_nickname = member_nickname;
	}
	
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public int getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(int member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_role() {
		return member_role;
	}
	public void setMember_role(String member_role) {
		this.member_role = member_role;
	}
	public String getMember_delflag() {
		return member_delflag;
	}
	public void setMember_delflag(String member_delflag) {
		this.member_delflag = member_delflag;
	}
	public Date getMember_regdate() {
		return member_regdate;
	}
	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	
	
	
	

}
