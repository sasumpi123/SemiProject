package com.plan.biz;

import java.util.List;

import com.plan.dto.planDto;

public interface planBiz {
	
	//선택한 보호소 detail
	public planDto selectOne(int seq);
	
	//파싱한 데이터(동물보호소) db저장
	public int insertList(List<planDto> list);
	

}
