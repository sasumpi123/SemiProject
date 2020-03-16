package com.member.dao;

import java.util.Random;

public class Util {
	public static String emailConfirm(int length) {
		char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		

		Random random = new Random(System.currentTimeMillis());
		int tablelength = characterTable.length;
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < length; i++) {
			buf.append(characterTable[random.nextInt(tablelength)]);
		}

		return buf.toString();
	}

	public static String madePassword(int length) {
		
		char[] passwordTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
				'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&',
				'*', '(', ')', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

		Random random = new Random(System.currentTimeMillis());
		int tablelength = passwordTable.length;
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < length; i++) {
			buf.append(passwordTable[random.nextInt(tablelength)]);
		}

		return buf.toString();

	}

}
