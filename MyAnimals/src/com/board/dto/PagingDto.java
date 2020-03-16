package com.board.dto;

public class PagingDto {
	
	private int rows;//한페이지당 보여줄 게시글수
	private int page;//현재 페이지
	private int startpage;//(그룹당)시작 페이지
	private int endpage;//(그룹당)끝 페이지
	private int pagescale;//그룹을 몇개로 묶을 것인지
	private int pagegroup;//그룹번호
	private int totalpage;//전체 페이지수
	
	public PagingDto() {}
	public PagingDto(int rows, int page, int startpage, int endpage, int pagescale, int pagegroup, int totalpage) {
		super();
		this.rows = rows;
		this.page = page;
		this.startpage = startpage;
		this.endpage = endpage;
		this.pagescale = pagescale;
		this.pagegroup = pagegroup;
		this.totalpage = totalpage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getEndpage() {
		return endpage;
	}
	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	public int getPagescale() {
		return pagescale;
	}
	public void setPagescale(int pagescale) {
		this.pagescale = pagescale;
	}
	public int getPagegroup() {
		return pagegroup;
	}
	public void setPagegroup(int pagegroup) {
		this.pagegroup = pagegroup;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	
	
	
	
}
