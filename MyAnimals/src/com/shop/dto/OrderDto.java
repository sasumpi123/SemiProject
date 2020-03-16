package com.shop.dto;

import java.util.Date;

public class OrderDto {
	private int order_seq;
	private int shop_seq;
	private String member_id;
	private String order_stuff;
	private Date regdate;
	private String order_content;
	private int order_count;
	private int order_buymoney;
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDto(int order_seq, int shop_seq, String member_id, String order_stuff, Date regdate,
			String order_content, int order_count, int order_buymoney) {
		super();
		this.order_seq = order_seq;
		this.shop_seq = shop_seq;
		this.member_id = member_id;
		this.order_stuff = order_stuff;
		this.regdate = regdate;
		this.order_content = order_content;
		this.order_count = order_count;
		this.order_buymoney = order_buymoney;
	}
	public int getOrder_seq() {
		return order_seq;
	}
	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
	}
	public int getShop_seq() {
		return shop_seq;
	}
	public void setShop_seq(int shop_seq) {
		this.shop_seq = shop_seq;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getOrder_stuff() {
		return order_stuff;
	}
	public void setOrder_stuff(String order_stuff) {
		this.order_stuff = order_stuff;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getOrder_content() {
		return order_content;
	}
	public void setOrder_content(String order_content) {
		this.order_content = order_content;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public int getOrder_buymoney() {
		return order_buymoney;
	}
	public void setOrder_buymoney(int order_buymoney) {
		this.order_buymoney = order_buymoney;
	}
	
	
}
