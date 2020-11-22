package com.ftf.naming.biz.enums;

/**
 * 星座
 * @author qumuasa
 *
 */
public enum ConstellationEnum {

	CAPRICORN(0,"Capricorn","摩羯座",""),
	AQUARIUS(1,"Aquarius","水瓶座",""),
	PISCES(2,"Pisces","双鱼座",""),
	ARIES(3,"Aries","白羊座",""),
	TAURUS(4,"Taurus","金牛座",""),
	GEMINI(5,"Gemini","双子座",""),
	CANCER(6,"Cancer","巨蟹座",""),
	LEO(7,"Leo","狮子座",""),
	VIRGO(8,"Virgo","处女座",""),
	LIBRA(9,"Libra","天秤座",""),
	SCORPIO(10,"Scorpio","天蝎座",""),
	SAGITTARIUS(11,"Sagittarius","射手座","");
	
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
	
	private ConstellationEnum (int index,String type,String name,String description) {
		this.index = index;
		this.type = type;
		this.name = name;
		this.description = description;
	}
	
	public static ConstellationEnum getByIndex(int index) {
		for(ConstellationEnum z : ConstellationEnum.values()) {
			if(z.getIndex().equals(index)) {
				return z;
			}
		}
		return null;
	}
	
	public static ConstellationEnum getByName(String name) {
		for(ConstellationEnum z : ConstellationEnum.values()) {
			if(z.getName().equals(name)) {
				return z;
			}
		}
		return null;
	}
}
