package com.calendar.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.calendar.dto.CalendarDto;
import com.calendar.dto.VolunteerDto;

public class Util {
	
	private String todates;
	
	public String getTodates() {
		
		return todates;
	}
	
	public void setTodates(String volunteer_mdate) {
		//yyyyMMddhhmm
		//yyyy-MM-dd hh:mm:00
		String m = volunteer_mdate.substring(0,4)+"-"+
				volunteer_mdate.substring(4,6)+"-"+
				volunteer_mdate.substring(6,8)+" "+
				volunteer_mdate.substring(8,10)+":"+
				volunteer_mdate.substring(10)+":00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		Timestamp tm = Timestamp.valueOf(m);
		todates = sdf.format(tm);
	}
	
	
	//font color 변경
	public static String fontColor(int date, int dayOfWeek) {
		
		String color = "";
		
		if((dayOfWeek-1+date)%7==1) {
			color="red";
		}else if((dayOfWeek-1+date)%7==0) {
			color="blue";
			
		}else {
			color="black";
		}
		
		return color;
	}
	
	
	
	
	//한자리수->두자리수
	public static String isTwo(String msg) {
		
		
		return (msg.length() <2)?"0"+msg:msg;
	}
	
	//삽입된 일정 띄워줌
	public static String getCalView(int date, List<VolunteerDto> clist) {
		String d = isTwo(date+"");
		String res = "";
		
		for(VolunteerDto dto : clist) {
			if(dto.getVolunteer_date().substring(6, 8).equals(d)) {
				res += "<p>"+
							((dto.getVolunteer_title().length()>6)?
									dto.getVolunteer_title().substring(0,6)+"...":
										dto.getVolunteer_title())+
										"</p>";
			}
		}
		
		return res;
	}

}
