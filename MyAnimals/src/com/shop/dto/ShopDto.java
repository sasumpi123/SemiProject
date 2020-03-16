package com.shop.dto;

public class ShopDto {

	private int shop_seq;
	private String shop_owner;
	private String shop_name;
	private String shop_kind;
	private int shop_price;
	private int shop_quantity;
	private String shop_content;
	private String shop_photo;
	public int getShop_seq() {
		return shop_seq;
	}
	public void setShop_seq(int shop_seq) {
		this.shop_seq = shop_seq;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_kind() {
		return shop_kind;
	}
	public void setShop_kind(String shop_kind) {
		this.shop_kind = shop_kind;
	}
	public int getShop_price() {
		return shop_price;
	}
	public void setShop_price(int shop_price) {
		this.shop_price = shop_price;
	}
	public int getShop_quantity() {
		return shop_quantity;
	}
	public void setShop_quantity(int shop_quantity) {
		this.shop_quantity = shop_quantity;
	}
	public String getShop_content() {
		return shop_content;
	}
	public void setShop_content(String shop_content) {
		this.shop_content = shop_content;
	}
	public String getShop_photo() {
		return shop_photo;
	}
	public void setShop_photo(String shop_photo) {
		this.shop_photo = shop_photo;
	}
	
	public ShopDto(int shop_seq, String shop_owner, String shop_name, String shop_kind, int shop_price,
			int shop_quantity, String shop_content, String shop_photo) {
		super();
		this.shop_seq = shop_seq;
		this.shop_owner = shop_owner;
		this.shop_name = shop_name;
		this.shop_kind = shop_kind;
		this.shop_price = shop_price;
		this.shop_quantity = shop_quantity;
		this.shop_content = shop_content;
		this.shop_photo = shop_photo;
	}
	public String getShop_owner() {
		return shop_owner;
	}
	public void setShop_owner(String shop_owner) {
		this.shop_owner = shop_owner;
	}
	
	
	
	public ShopDto() {}
	

}
