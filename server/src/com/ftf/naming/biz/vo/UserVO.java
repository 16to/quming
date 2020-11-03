package com.ftf.naming.biz.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户信息")
public class UserVO {

	@ApiModelProperty("用户ID")
	private String userId;
	@ApiModelProperty("用户名")
	private String name;
	@ApiModelProperty("手机号")
	private String phone;
}
