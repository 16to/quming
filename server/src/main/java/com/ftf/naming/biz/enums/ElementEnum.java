package com.ftf.naming.biz.enums;

/**
 * 五行
 * @author qumuasa
 *
 */
public enum ElementEnum {

	METAL("metal","金","具有清静、收杀的特性，属西方"),
	WOOD("wood","木","具有生发，条达的特性，属东方"),
	WATER("water","水","具有寒冷、向下的特性，属北方"),
	FIRE("fire","火","具有炎热，向上的特性，属南方"),
	EARTH("earth","土","具有长养、化育的特性，属中央");
	
	private String type;
	private String name;
	private String explanation;
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public String getExplanation() {
		return explanation;
	}
	
	private ElementEnum (String type,String name,String explanation) {
		this.type = type;
		this.name = name;
		this.explanation = explanation;
	}
	
	public static ElementEnum getByName(String name) {
		for(ElementEnum e : ElementEnum.values()) {
			if(e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}
