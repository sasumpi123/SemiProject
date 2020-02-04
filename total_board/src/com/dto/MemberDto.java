package com.dto;

public class MemberDto {
	private int mbno;
	private String mbid;
	private String mbpw;
	private String mbname;
	private String mbaddr;
	private String mbphone;
	private String mbemail;
	private String mbenabled;
	private String mbrole;
	public int getMbno() {
		return mbno;
	}
	public void setMbno(int mbno) {
		this.mbno = mbno;
	}
	public String getMbid() {
		return mbid;
	}
	public void setMbid(String mbid) {
		this.mbid = mbid;
	}
	public String getMbpw() {
		return mbpw;
	}
	public void setMbpw(String mbpw) {
		this.mbpw = mbpw;
	}
	public String getMbname() {
		return mbname;
	}
	public void setMbname(String mbname) {
		this.mbname = mbname;
	}
	public String getMbaddr() {
		return mbaddr;
	}
	public void setMbaddr(String mbaddr) {
		this.mbaddr = mbaddr;
	}
	public String getMbphone() {
		return mbphone;
	}
	public void setMbphone(String mbphone) {
		this.mbphone = mbphone;
	}
	public String getMbemail() {
		return mbemail;
	}
	public void setMbemail(String mbemail) {
		this.mbemail = mbemail;
	}
	public String getMbenabled() {
		return mbenabled;
	}
	public void setMbenabled(String mbenabled) {
		this.mbenabled = mbenabled;
	}
	public String getMbrole() {
		return mbrole;
	}
	public void setMbrole(String mbrole) {
		this.mbrole = mbrole;
	}
	public MemberDto(int mbno, String mbid, String mbpw, String mbname, String mbaddr, String mbphone, String mbemail,
			String mbenabled, String mbrole) {
		super();
		this.mbno = mbno;
		this.mbid = mbid;
		this.mbpw = mbpw;
		this.mbname = mbname;
		this.mbaddr = mbaddr;
		this.mbphone = mbphone;
		this.mbemail = mbemail;
		this.mbenabled = mbenabled;
		this.mbrole = mbrole;
	}
	
	public MemberDto() {
		
	}

}
