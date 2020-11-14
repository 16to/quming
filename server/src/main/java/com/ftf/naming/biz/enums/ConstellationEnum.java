package com.ftf.naming.biz.enums;

/**
 * 星座
 * @author qumuasa
 *
 */
public enum ConstellationEnum {

	ARIES("Aries","白羊座"),
	GEMINI("Gemini","双子座"),
	LEO("Leo","狮子座"),
	LIBRA("Libra","天秤座"),
	SAGITTARIUS("Sagittarius","射手座"),
	AQUARIUS("Aquarius","水瓶座"),
	TAURUS("Taurus","金牛座"),
	CANCER("Cancer","巨蟹座"),
	VIRGO("Virgo","处女座"),
	SCORPIO("Scorpio","天蝎座"),
	CAPRICORN("Capricorn","摩羯座"),
	PISCES("Pisces","双鱼座");
	
	private String type;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	private ConstellationEnum (String type,String name) {
		this.type = type;
		this.name = name;
	}
}
