package com.calendar.biz;

import java.util.List;

import com.calendar.dao.calendarDao;
import com.calendar.dao.calendarDaoImpl;
import com.calendar.dto.ApplyDto;
import com.calendar.dto.CalendarDto;
import com.calendar.dto.VolunteerDto;

public class calendarBizImpl implements calendarBiz {
	
	calendarDao dao = new calendarDaoImpl();

	@Override
	public VolunteerDto selectOne(int center_seq,String yyyyMMdd) {
		VolunteerDto dto = dao.selectOne(center_seq, yyyyMMdd);
		dto.setVlounteer_nowvolunteer(dao.countvolunteer(dto.getVolunteer_seq()));
		return dto;
	}

	@Override
	public int insert(VolunteerDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(CalendarDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int volunteer_seq) {
		return dao.delete(volunteer_seq);
	}
	
	public List<VolunteerDto> getCalViewList(String member_id, String yyyyMM, int center_seq){
		return dao.getCalViewList(member_id, yyyyMM, center_seq);
	}
	
	public int getCalCount(String id, String yyyyMMdd) {
		return 0;
		
	}
	
	public int insertCalBoard(CalendarDto dto) {
		return dao.insertCalBoard(dto);
		
	}
	
	public int applyInsert(ApplyDto applyDto) {
		
		return dao.applyInsert(applyDto);
	}

}
