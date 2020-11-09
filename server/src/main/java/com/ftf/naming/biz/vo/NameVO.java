package com.ftf.naming.biz.vo;

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

	@ApiModelProperty("姓")
	private String firstName;
	@ApiModelProperty("名")
	private String lastName;
	@ApiModelProperty("笔画")
	private String strokes;
	@ApiModelProperty("拼音")
	private String pinyin;
	@ApiModelProperty("解释")
	private String explanation;
	
	public NameVO(String firstName, NameDTO data) {
		this.firstName = firstName;
		this.lastName = data.getWord();
		this.strokes = data.getStrokes();
		this.pinyin = data.getPinyin();
		this.explanation = data.getExplanation();
	}
}
