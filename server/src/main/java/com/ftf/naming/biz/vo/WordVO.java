package com.ftf.naming.biz.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("汉字")
public class WordVO {
	
	@ApiModelProperty("字")
	private String word;
	@ApiModelProperty("繁体")
	private String oldword;
	@ApiModelProperty("笔画")
	private Integer strokes;
	@ApiModelProperty("拼音")
	private String pinyin;
	@ApiModelProperty("字典释义")
	private String explanation;
	
	@ApiModelProperty("五行")
	private Element element;
	
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ApiModel("五行")
	public static class Element{
		@ApiModelProperty("类型")
		private String type;
		@ApiModelProperty("名称")
		private String name;
		@ApiModelProperty("解释")
		private String explanation;
	}
}
