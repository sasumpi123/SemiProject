package com.board.dto;

import java.util.Date;

public class BoardDto {

	
	private int board_seq;
	private String member_nickname;
	private String board_title;
	private String board_content;
	private Date board_regdate;
	private int board_regroup;
	private int board_restep;
	private int board_titletab;
	private String board_delflag;
	private int board_views;
	
	
	public BoardDto() {}
	
	public BoardDto(int board_seq, String member_nickname, String board_title, String board_content, Date board_regdate,
			int board_regroup, int board_restep, int board_titletab, String board_delflag, int board_views) {
		super();
		this.board_seq = board_seq;
		this.member_nickname = member_nickname;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_regdate = board_regdate;
		this.board_regroup = board_regroup;
		this.board_restep = board_restep;
		this.board_titletab = board_titletab;
		this.board_delflag = board_delflag;
		this.board_views = board_views;
	}

	public BoardDto(String member_nickname, String board_title, String board_content) {
		super();
		this.member_nickname = member_nickname;
		this.board_title = board_title;
		this.board_content = board_content;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public Date getBoard_regdate() {
		return board_regdate;
	}

	public void setBoard_regdate(Date board_regdate) {
		this.board_regdate = board_regdate;
	}

	public int getBoard_regroup() {
		return board_regroup;
	}

	public void setBoard_regroup(int board_regroup) {
		this.board_regroup = board_regroup;
	}

	public int getBoard_restep() {
		return board_restep;
	}

	public void setBoard_restep(int board_restep) {
		this.board_restep = board_restep;
	}

	public int getBoard_titletab() {
		return board_titletab;
	}

	public void setBoard_titletab(int board_titletab) {
		this.board_titletab = board_titletab;
	}

	public String getBoard_delflag() {
		return board_delflag;
	}

	public void setBoard_delflag(String board_delflag) {
		this.board_delflag = board_delflag;
	}

	public int getBoard_views() {
		return board_views;
	}

	public void setBoard_views(int board_views) {
		this.board_views = board_views;
	}
}
