package com.calendar.biz;

import java.util.List;

import com.calendar.dto.ApplyDto;
import com.calendar.dto.CalendarDto;
import com.calendar.dto.VolunteerDto;

public interface calendarBiz {
	
	public VolunteerDto selectOne(int center_seq,String yyyyMMdd);
	public int insert(VolunteerDto dto);
	public int update(CalendarDto dto);
	public int delete(int volunteer_seq);
	public List<VolunteerDto> getCalViewList(String member_id, String yyyyMM, int center_seq);
	public int getCalCount(String id, String yyyyMMdd);
	public int insertCalBoard(CalendarDto dto);
	public int applyInsert(ApplyDto applyDto);


}
