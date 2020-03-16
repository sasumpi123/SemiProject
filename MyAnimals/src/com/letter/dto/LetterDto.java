package com.letter.dto;

import java.util.Date;

public class LetterDto {
	private int letter_seq;
	private String member_from;
	private String member_to;
	private String letter_title;
	private String letter_content;
	private Date letter_regdate;
	private String letter_read;
	
	
	public LetterDto() {

	}
	
	
	public LetterDto(int letter_seq, String member_from, String member_to, String letter_title, String letter_content,
			Date letter_regdate, String letter_read) {

		this.letter_seq = letter_seq;
		this.member_from = member_from;
		this.member_to = member_to;
		this.letter_title = letter_title;
		this.letter_content = letter_content;
		this.letter_regdate = letter_regdate;
		this.letter_read = letter_read;
	}
	public int getLetter_seq() {
		return letter_seq;
	}
	public void setLetter_seq(int letter_seq) {
		this.letter_seq = letter_seq;
	}
	public String getMember_from() {
		return member_from;
	}
	public void setMember_from(String member_from) {
		this.member_from = member_from;
	}
	public String getMember_to() {
		return member_to;
	}
	public void setMember_to(String member_to) {
		this.member_to = member_to;
	}
	public String getLetter_title() {
		return letter_title;
	}
	public void setLetter_title(String letter_title) {
		this.letter_title = letter_title;
	}
	public String getLetter_content() {
		return letter_content;
	}
	public void setLetter_content(String letter_content) {
		this.letter_content = letter_content;
	}
	public Date getLetter_regdate() {
		return letter_regdate;
	}
	public void setLetter_regdate(Date letter_regdate) {
		this.letter_regdate = letter_regdate;
	}
	public String getLetter_read() {
		return letter_read;
	}
	public void setLetter_read(String letter_read) {
		this.letter_read = letter_read;
	}
	
	
	
}
