package com.alarm.biz;

import java.util.List;

import com.alarm.dto.AlarmDateDto;


public interface AlarmBiz {
	public List<AlarmDateDto> getDate(String member_id, String date);
}
