package com.ftf.naming.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftf.naming.biz.HttpResult;
import com.ftf.naming.biz.param.NewNameParam;
import com.ftf.naming.biz.service.NameService;
import com.ftf.naming.biz.vo.NameVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/name/")
@Api(tags="名字模块")
public class NameController {
	
	@Autowired
	private NameService nameService;

	@ApiOperation("生成新名字")
	@PostMapping("actions/generate")
	public HttpResult<NameVO> newName(@RequestBody NewNameParam param) {
		return HttpResult.success(nameService.newName(param));
	}
	
	@ApiOperation("喜欢")
	@PostMapping("actions/like")
	public HttpResult likeName(@RequestParam String userId,@RequestParam String nameId) {
		return HttpResult.success();
	}
	
	@ApiOperation("收藏")
	@PostMapping("actions/collect")
	public HttpResult collectName(@RequestParam String userId,@RequestParam String nameId) {
		return HttpResult.success();
	}
	
	@ApiOperation("发送")
	@PostMapping("actions/send")
	public HttpResult send(@RequestParam String userId,@RequestParam String nameId) {
		return HttpResult.success();
	}
}
