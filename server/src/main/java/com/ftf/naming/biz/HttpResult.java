package com.ftf.naming.biz;

import com.ftf.naming.biz.enums.ResultCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResult<T> {

	private String code;
	private String message;
	private Object data;
	
	public static HttpResult success() {
		return new HttpResult("0","成功",null);
	}
	
	public static HttpResult success(Object data) {
		return new HttpResult("0","成功",data);
	}
	
	public HttpResult(ResultCode resultCode) {
		this.setCode(resultCode.getCode());
		this.setMessage(resultCode.getMsg());
	}
	
	public HttpResult(ResultCode resultCode,Object data) {
		this.setCode(resultCode.getCode());
		this.setMessage(resultCode.getMsg());
		this.setData(data);
	}
}
