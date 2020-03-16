package com.shop.biz;

import java.util.List;

import com.shop.dao.ShopDao;
import com.shop.dao.ShopDaoImpl;
import com.shop.dto.ShopDto;


public class ShopBizImpl implements ShopBiz {
	ShopDao dao = new ShopDaoImpl();
	@Override
	public List<ShopDto> selectShopList() {
		// TODO Auto-generated method stub
		return dao.selectShopList();
	}

	@Override
	public ShopDto selectShopOne(int shop_seq) {
		// TODO Auto-generated method stub
		return dao.selectShopOne(shop_seq);
	}

	@Override
	public int insertShopList(ShopDto dto) {
//		if(dto.getShop_photo().equals("not")) {
//			dto.getShop_photo()
//		}
		return dao.insertShopList(dto);
		
	}

	@Override
	public int deleteShopList(int shop_seq) {
		// TODO Auto-generated method stub
		return dao.deleteShopList(shop_seq);
	}

	@Override
	public int updateShopList(ShopDto dto) {
		// TODO Auto-generated method stub
		return dao.updateShopList(dto);
	}

	@Override
	public List<ShopDto> search(String searchTitle,String searchContent) {
		// TODO Auto-generated method stub
		return dao.search(searchTitle, searchContent);
	}

}
