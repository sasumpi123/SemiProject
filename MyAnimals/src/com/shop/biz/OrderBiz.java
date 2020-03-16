package com.shop.biz;

import java.util.List;

import com.shop.dto.OrderDto;

public interface OrderBiz {
	public List<OrderDto> selectOrderList();
	public OrderDto selectOrderList(int order_seq);
	public int insertOrderList(OrderDto dto);
	public int updateOrderList(int shop_seq,int opt);
}
