package com.shop.biz;

import java.util.List;

import com.shop.dao.OrderDao;
import com.shop.dao.OrderDaoImpl;
import com.shop.dto.OrderDto;

public class OrderBizImpl implements OrderBiz {
	OrderDao dao = new OrderDaoImpl();
	@Override
	public List<OrderDto> selectOrderList() {
		// TODO Auto-generated method stub
		return dao.selectOrderList();
	}

	@Override
	public OrderDto selectOrderList(int order_seq) {
		// TODO Auto-generated method stub
		return dao.selectOrderList(order_seq);
	}

	@Override
	public int insertOrderList(OrderDto dto) {
		// TODO Auto-generated method stub
		return dao.insertOrderList(dto);
	}

	@Override
	public int updateOrderList(int shop_seq,int opt) {
		// TODO Auto-generated method stub
		return dao.updateOrderList(shop_seq,opt);
	}

}
