package com.plan.dao;

import java.util.List;

import com.plan.dto.planDto;

public interface planDao {
	
	//선택한 보호소 detail
	public planDto selectOne(int seq);
	
	//파싱한 데이터(동물보호소) db저장
	public int insertList(List<planDto> list);
	

	public List<planDto> selectList();

}
