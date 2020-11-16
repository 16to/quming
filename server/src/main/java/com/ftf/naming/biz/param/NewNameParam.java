package com.ftf.naming.biz.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("取名参数")
public class NewNameParam {

	@ApiModelProperty("姓")
	private String firstName;
	@ApiModelProperty("生日")
	private String birth;
	@ApiModelProperty("性别")
	private Integer sex;
	@ApiModelProperty("筛选参数")
	private SelectParam selectParam;
	
	@Data
	@ApiModel("筛选参数")
	public class SelectParam{
		@ApiModelProperty("长度")
		private Integer length;
		@ApiModelProperty("五行")
		private String element;
		@ApiModelProperty("出处")
		private String source;
	}
}
