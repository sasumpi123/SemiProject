package com.alarm.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alarm.dto.AlarmDto;
import com.mybatis.db.SqlMapConfig;

public class AlarmDaoImpl extends SqlMapConfig implements AlarmDao {
	String namespace = "alarm.";

	@Override
	public List<AlarmDto> getDate(String member_id) {
		SqlSession session = null;
	    List<AlarmDto> list = new ArrayList<>();
	    
	    try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"getDate", member_id);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return list;
	}

	//SELECT * FROM alarm where trunc(TO_DATE(ALARM_DATE,'yyyymmdd')) - trunc(TO_DATE(#{date},'yyyymmdd')) <![CDATA[<=]]> 7
}
