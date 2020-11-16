package com.ftf.naming.biz.enums;

/**
 * 出处
 * @author qumuasa
 *
 */
public enum SourceEnum {

	SHIJING("shijing","诗经"),
	CHUCI("chuci","楚辞"),
	LUNYU("lunyu","论语"),
	TANGSHI("tangshi","唐诗"),
	SONGCI("songci","宋词");
	
	private String type;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	private SourceEnum (String type,String name) {
		this.type = type;
		this.name = name;
	}
}
