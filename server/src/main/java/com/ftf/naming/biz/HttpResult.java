package com.ftf.naming.biz;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpResult<T> {

	private Integer code;
	private String message;
	private Object data;
	
	public static HttpResult success() {
		return new HttpResult(0,"成功",null);
	}
	
	public static HttpResult success(Object data) {
		return new HttpResult(0,"成功",data);
	}
}
