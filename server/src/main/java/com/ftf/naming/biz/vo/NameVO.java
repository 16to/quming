package com.ftf.naming.biz.vo;

import java.util.UUID;

import com.ftf.naming.biz.dto.NameDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("名字")
public class NameVO {

	@ApiModelProperty("名字唯一标识")
	private String id;
	@ApiModelProperty("姓")
	private String firstName;
	@ApiModelProperty("名")
	private String lastName;
	@ApiModelProperty("长度")
	private Integer length;
	@ApiModelProperty("繁体")
	private String oldword;
	@ApiModelProperty("笔画")
	private Integer strokes;
	@ApiModelProperty("拼音")
	private String pinyin;
	@ApiModelProperty("字典释义")
	private String explanation;
	@ApiModelProperty("出处")
	private String source;
	@ApiModelProperty("名人")
	private String celebrity;
	
	@ApiModelProperty("生肖")
	private Zodiac zodiac;
	@ApiModelProperty("星座")
	private Constellation constellation;
	@ApiModelProperty("五行")
	private Element element;
	@ApiModelProperty("同名")
	private Same same;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ApiModel("生肖")
	public static class Zodiac{
		@ApiModelProperty("类型")
		private String type;
		@ApiModelProperty("名称")
		private String name;
		@ApiModelProperty("详情")
		private String attr;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ApiModel("星座")
	public static class Constellation{
		@ApiModelProperty("类型")
		private String type;
		@ApiModelProperty("名称")
		private String name;
		@ApiModelProperty("详情")
		private String attr;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ApiModel("五行")
	public static class Element{
		@ApiModelProperty("类型")
		private String type;
		@ApiModelProperty("名称")
		private String name;
		@ApiModelProperty("详情")
		private String attr;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ApiModel("同名")
	public static class Same{
		@ApiModelProperty("男性")
		private Integer male;
		@ApiModelProperty("女性")
		private Integer female;
	}
	
	public NameVO(String firstName, NameDTO data) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = data.getWord();
		this.oldword = data.getOldword();
		this.strokes = Integer.valueOf(data.getStrokes());
		this.pinyin = data.getPinyin();
		this.explanation = data.getExplanation();
	}
}
