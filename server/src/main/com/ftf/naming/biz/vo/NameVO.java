package com.ftf.naming.biz.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("������Ϣ")
public class NameVO {

	@ApiModelProperty("��")
	private String firstName;
	@ApiModelProperty("��")
	private String lastName;
}
