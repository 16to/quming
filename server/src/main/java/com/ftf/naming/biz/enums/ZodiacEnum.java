package com.ftf.naming.biz.enums;

/**
 * 生肖
 * @author qumuasa
 *
 */
public enum ZodiacEnum {

	RAT("Rat","鼠"),
	OX("OX","牛"),
	TIGER("Tiger","虎"),
	RABBIT("Rabbit","兔"),
	DRAGON("Dragon","龙"),
	SNAKE("Snake","蛇"),
	HORSE("Horse","马"),
	SHEEP("Sheep","羊"),
	MONKEY("Monkey","猴"),
	ROOSTER("Rooster","鸡"),
	DOG("Dog","狗"),
	PIG("Pig","猪");
	
	private String type;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	private ZodiacEnum (String type,String name) {
		this.type = type;
		this.name = name;
	}
}
