package com.ftf.naming.biz.enums;

/**
 * 生肖
 * @author qumuasa
 *
 */
public enum ZodiacEnum {

	RAT(0,"Rat","鼠",""),
	OX(1,"OX","牛",""),
	TIGER(2,"Tiger","虎",""),
	RABBIT(3,"Rabbit","兔",""),
	DRAGON(4,"Dragon","龙",""),
	SNAKE(5,"Snake","蛇",""),
	HORSE(6,"Horse","马",""),
	SHEEP(7,"Sheep","羊",""),
	MONKEY(8,"Monkey","猴",""),
	ROOSTER(9,"Rooster","鸡",""),
	DOG(10,"Dog","狗",""),
	PIG(11,"Pig","猪","");
	
	private Integer index;
	private String type;
	private String name;
	private String description;
	
	public Integer getIndex() {
		return index;
	}
	
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	private ZodiacEnum (int index,String type,String name,String description) {
		this.index = index;
		this.type = type;
		this.name = name;
		this.description = description;
	}
	
	public static ZodiacEnum getByIndex(int index) {
		for(ZodiacEnum z : ZodiacEnum.values()) {
			if(z.getIndex().equals(index)) {
				return z;
			}
		}
		return null;
	}
	
	public static ZodiacEnum getByName(String name) {
		for(ZodiacEnum z : ZodiacEnum.values()) {
			if(z.getName().equals(name)) {
				return z;
			}
		}
		return null;
	}
}
