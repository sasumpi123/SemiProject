package com.shop.dao;

import java.util.List;

import com.shop.dto.OrderDto;

public interface OrderDao {
	public List<OrderDto> selectOrderList();
	public OrderDto selectOrderList(int order_seq);
	public int insertOrderList(OrderDto dto);
	public int updateOrderList(int shop_seq,int opt);
}
