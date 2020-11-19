package com.ftf.naming.biz.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("收藏参数")
public class CollectNameParam {

	@ApiModelProperty("用户Id")
	private String userId;
	@ApiModelProperty("名字Id")
	private String nameId;
}
