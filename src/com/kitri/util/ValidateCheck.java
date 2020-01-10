package com.kitri.util;

public class ValidateCheck {

	public static int nullToZero(String tmp) {
		int num = 0;
		if(isNumber(tmp))
				num = Integer.parseInt(tmp);
		return num;
	}
	
	public static int nullToOne(String tmp) {
		int num = 1; // null이거나 숫자가 아닌 게 넘어오면 무조건 1로 변환
		if(isNumber(tmp))
				num = Integer.parseInt(tmp);
		return num;
	}
	
	public static String nullToBlank(String tmp) {
		//null인경우 빈값을 넘기도록
		return tmp != null ? tmp : "";
	}

	private static boolean isNumber(String tmp) {
		boolean flag = true;
		if(tmp != null) {
			int len = tmp.length();
			for(int i=0;i<len; i++) {
				int x = tmp.charAt(i) - 48;
				if(x<0 || x>9) {
					flag = false;
					break;
				}
			}
		} else {
			flag = false;
		}
		
		return flag;
	}
}
