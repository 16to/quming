package com.ftf.naming.util;

import java.util.UUID;

public class UuidUtil {

	public static String create() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
