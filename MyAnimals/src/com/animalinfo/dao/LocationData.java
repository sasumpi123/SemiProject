package com.animalinfo.dao;

import java.util.HashMap;
import java.util.Map;

public class LocationData {

	public static int sidoNumber(String sido){
		System.out.println("location : "+sido);
		if(sido.equals("서울특별시")) {
			return 6110000;
		}else if(sido.equals("인천광역시")) {
			return 6280000;
		}else if(sido.equals("대전광역시")) {
			return 6300000;
		}else if(sido.equals("광주광역시")) {
			return 6290000;
		}else if(sido.equals("대구광역시")) {
			return 6270000;
		}else if(sido.equals("울산광역시")) {
			return 6310000;
		}else if(sido.equals("부산광역시")) {
			return 6260000;
		}else if(sido.equals("경기도")) {
			return 6410000;
		}else if(sido.equals("강원도")) {
			return 6420000;
		}else if(sido.equals("충청북도")) {
			return 6430000;
		}else if(sido.equals("충청남도")) {
			return 6440000;
		}else if(sido.equals("전라북도")) {
			return 6450000;
		}else if(sido.equals("전라남도")) {
			return 6460000;
		}else if(sido.equals("경상북도")) {
			return 6470000;
		}else if(sido.equals("경상남도")) {
			return 6480000;
		}else if(sido.equals("제주도")) {
			return 6500000;
		}else {
			return 0;
		}
	}
	
	public static int getKindUp(String kind) {
		if(kind.equals("개")) {
			return 417000; 
		}else if(kind.equals("고양이")) {
			return 422400;
		}else {
			return 429900;
		}
		
	}
}
