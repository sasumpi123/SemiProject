package com.alarm.dao;


import java.util.List;

import com.alarm.dto.AlarmDto;

public interface AlarmDao {
	public List<AlarmDto> getDate(String member_id);
}
