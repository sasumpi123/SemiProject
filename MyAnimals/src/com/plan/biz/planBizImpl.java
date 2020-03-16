package com.plan.biz;

import java.util.List;

import com.plan.dao.planDao;
import com.plan.dao.planDaoImpl;
import com.plan.dto.planDto;

public class planBizImpl implements planBiz {
	
	private planDao dao = new planDaoImpl();

	@Override
	//선택한 보호소 detail
	public planDto selectOne(int seq) {
		
		return dao.selectOne(seq);
	}

	@Override
	//파싱한 데이터(동물보호소) db저장
	public int insertList(List<planDto> list) {
		
		return dao.insertList(list);
	}

}
