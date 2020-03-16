package com.alarm.dao;

public class Util {
	public static String isTwo(String msg) {
		if (msg.length() == 1) {
			return "0" + msg;
		} else {
			return msg;
		}
	}
}
