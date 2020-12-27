package com.ftf.naming.biz.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XHWordDAO {

	private String word;
	private String oldword;
	private Integer strokes;
	private String pinyin;
	private String radicals;
	private String explanation;
	private String more;
	private String wx;
	private String jg;
}
