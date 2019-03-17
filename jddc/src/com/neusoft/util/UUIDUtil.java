package com.neusoft.util;

import java.util.UUID;

public class UUIDUtil {

	public static String uuidStr(){
		return  UUID.randomUUID().toString().replaceAll("-", "");
	}
}
