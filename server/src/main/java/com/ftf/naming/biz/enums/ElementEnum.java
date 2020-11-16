package com.ftf.naming.biz.enums;

/**
 * 五行
 * @author qumuasa
 *
 */
public enum ElementEnum {

	METAL("metal","金"),
	WOOD("wood","木"),
	WATER("water","水"),
	FIRE("fire","火"),
	EARTH("earth","土");
	
	private String type;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	private ElementEnum (String type,String name) {
		this.type = type;
		this.name = name;
	}
}
