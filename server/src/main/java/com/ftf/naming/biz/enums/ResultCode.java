package com.ftf.naming.biz.enums;

public enum ResultCode {

	SUCCESS("0", "Success"),
	FAILED("999999","Failed");
 
    private String code;
    private String msg;
 
    private ResultCode(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
 
    public String getMsg(){
        return this.msg;
    }
    public String getCode(){
        return this.code;
    }
}
