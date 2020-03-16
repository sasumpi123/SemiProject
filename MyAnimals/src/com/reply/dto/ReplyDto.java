package com.reply.dto;

import java.util.Date;

public class ReplyDto {

	private int reply_seq;
	private int board_seq;
	private String member_id;
	private String reply_content;
	private Date reply_regdate;
	
	public ReplyDto() {};
	
	public ReplyDto(int reply_seq, int board_seq, String member_id, String reply_content, Date reply_regdate) {
		super();
		this.reply_seq = reply_seq;
		this.board_seq = board_seq;
		this.member_id = member_id;
		this.reply_content = reply_content;
		this.reply_regdate = reply_regdate;
	}
	
	public int getReply_seq() {
		return reply_seq;
	}
	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_regdate() {
		return reply_regdate;
	}
	public void setReply_regdate(Date reply_regdate) {
		this.reply_regdate = reply_regdate;
	}
	
	
	
	
	
}
