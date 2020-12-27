package com.ftf.naming.util;

import java.util.List;

import com.ftf.naming.biz.Rule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RuleUtil {

	private static Rule rule = null;
	
	public static void init(String source) {
		try {
			rule = new Rule(source);
		}
		catch(Exception e) {
			log.error("规则初始化失败",e);
		}
	}
	
	public static List<String> run(String[] source) {
		if(rule == null) {
			log.error("规则未初始化");
			return null;
		}
		return rule.run(source);
	}
}
