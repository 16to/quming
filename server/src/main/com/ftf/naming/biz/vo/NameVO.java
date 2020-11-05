package com.ftf.naming.biz.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("名字信息")
public class NameVO {

	@ApiModelProperty("姓")
	private String firstName;
	@ApiModelProperty("名")
	private String lastName;
}
