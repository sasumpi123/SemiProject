package com.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.db.SqlMapConfig;
import com.shop.dto.OrderDto;

public class OrderDaoImpl extends SqlMapConfig implements OrderDao {
	String namespace = "shop.";
	@Override
	public List<OrderDto> selectOrderList() {
		SqlSession session = null;
		List<OrderDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"selectOrderList");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public OrderDto selectOrderList(int order_seq) {
		SqlSession session = null;
		OrderDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"selectOrderList",order_seq);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int insertOrderList(OrderDto dto) {
		SqlSession session = null;
		int ui = 0;
		
		System.out.println(ui);
		try {
			session = getSqlSessionFactory().openSession();
			ui = session.insert(namespace+"insertOrder",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return ui;
	}

	@Override
	public int updateOrderList(int shop_seq,int opt) {
		SqlSession session = null;
		int res = 0;
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("shop_seq", shop_seq);
		map.put("opt", opt);
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace+"updateOrder",map);
		} catch (Exception e) {
			System.out.println("[error] : updatOrder");
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return res;
	}

}
