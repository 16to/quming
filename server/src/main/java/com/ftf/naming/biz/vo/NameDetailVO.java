package com.ftf.naming.biz.vo;

import java.util.List;

import com.ftf.naming.biz.enums.ConstellationEnum;
import com.ftf.naming.biz.enums.ZodiacEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("名字详情")
public class NameDetailVO {

	@ApiModelProperty("名字唯一标识")
	private String id;
	@ApiModelProperty("姓")
	private WordVO firstName;
	@ApiModelProperty("长度")
	private Integer length;
	@ApiModelProperty("出处")
	private String source;
	@ApiModelProperty("名人")
	private List<String> celebrities;
	
	
	@ApiModelProperty("生肖")
	private Zodiac zodiac;
	@ApiModelProperty("星座")
	private Constellation constellation;
	@ApiModelProperty("同名")
	private Same same;
	
	@ApiModelProperty("名")
	private List<WordVO> lastName;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ApiModel("生肖")
	public static class Zodiac{
		@ApiModelProperty("类型")
		private String type;
		@ApiModelProperty("名称")
		private String name;
		@ApiModelProperty("解释")
		private String explanation;
		
		public Zodiac(ZodiacEnum data) {
			this.type = data.getType();
			this.name = data.getName();
			this.explanation = data.getDescription();
		}
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
		@ApiModelProperty("解释")
		private String explanation;
		
		public Constellation(ConstellationEnum data) {
			this.type = data.getType();
			this.name = data.getName();
			this.explanation = data.getDescription();
		}
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
}
