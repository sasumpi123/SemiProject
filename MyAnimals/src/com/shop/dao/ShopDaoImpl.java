package com.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.db.SqlMapConfig;
import com.shop.dto.ShopDto;

public class ShopDaoImpl extends SqlMapConfig implements ShopDao {

	String namespace = "shop.";

	@Override
	public List<ShopDto> selectShopList() {

		SqlSession session = null;
		List<ShopDto> list = null;

		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "selectShopList");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public ShopDto selectShopOne(int shop_seq) {
		SqlSession session = null;
		ShopDto dto = null;
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace + "selectShopOne", shop_seq);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int insertShopList(ShopDto dto) {
		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			res = session.insert(namespace + "insertShop", dto);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int deleteShopList(int shop_seq) {

		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			res = session.delete(namespace + "deleteShop", shop_seq);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int updateShopList(ShopDto dto) {
		SqlSession session = null;
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace + "updateShop", dto);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}
		return res;

	}

	@Override
	public List<ShopDto> search(String searchTitle, String searchContent) {
		SqlSession session = null;
		List<ShopDto> list = null;
		System.out.println("dao안 searchTitle :  " + searchTitle);
		System.out.println("dao안 searchContent : " + searchContent);
		
		try {
			session = getSqlSessionFactory().openSession();
			if(searchTitle.equals("이름")) {
				list = session.selectList(namespace + "searchName",searchContent);
			}else if(searchTitle.equals("상품종류")) {
				list = session.selectList(namespace + "searchKind",searchContent);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

		
		return list;
	}

}
