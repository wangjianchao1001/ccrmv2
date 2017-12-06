package com.ccrm.util;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author  张代浩
 *
 */
public class PkidGenerator {
	
	public static String randomNumber(int count){
		
		if(count < 1){
			return null;
		}
		String str = "";
		String arr = "1234567890";
		for(int i = 0 ; i < count ; i++){
			int rnd = Math.abs(new Random().nextInt(10));
			str += arr.substring(rnd, rnd + 1);
		}
		return DateTimeUtils.getDateTimeStr(new Date(), "yyyyMMddHHmmssms") + str;
	}
	
}
