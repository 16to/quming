package com.ftf.naming.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新华字典词汇
 * @author qumuasa
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XHwordDTO {
	private String word;
	private String oldword;
	private String strokes;
	private String pinyin;
	private String radicals;
	private String explanation;
	private String more;
	private String wx;
	private String jg;
}
