package com.ftf.naming.biz.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("�û���Ϣ")
public class UserVO {

	@ApiModelProperty("�û�ID")
	private String userId;
	@ApiModelProperty("�û���")
	private String name;
	@ApiModelProperty("�ֻ���")
	private String phone;
}
