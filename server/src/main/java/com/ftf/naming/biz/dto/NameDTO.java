package com.ftf.naming.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameDTO {
	private String word;
	private String oldword;
	private String strokes;
	private String pinyin;
	private String radicals;
	private String explanation;
	private String more;
}
