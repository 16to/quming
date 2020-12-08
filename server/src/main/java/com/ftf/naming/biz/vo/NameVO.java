package com.ftf.naming.biz.vo;

import java.util.List;

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
	private WordVO firstName;
	@ApiModelProperty("姓")
	private Integer length;
	
	@ApiModelProperty("生肖")
	private String zodiac;
	@ApiModelProperty("星座")
	private String constellation;
	
	@ApiModelProperty("出处")
	private String source;
	
	@ApiModelProperty("名")
	private List<WordVO> lastName;
}
