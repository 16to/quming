package com.ftf.naming.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftf.naming.biz.HttpResult;
import com.ftf.naming.biz.param.CollectNameParam;
import com.ftf.naming.biz.param.NewNameParam;
import com.ftf.naming.biz.service.NameService;
import com.ftf.naming.biz.vo.NameDetailVO;
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
	public HttpResult<List<NameVO>> generate(@RequestBody NewNameParam param) {
		return HttpResult.success(nameService.generate(param));
	}
	
	@ApiOperation("详情")
	@GetMapping("detail")
	public HttpResult<NameDetailVO> nameDetail(@RequestParam String nameId) {
		return HttpResult.success(nameService.getNameDetail(nameId));
	}
	
	@ApiOperation("收藏")
	@PostMapping("actions/collect")
	public HttpResult collectName(@RequestBody CollectNameParam param) {
		nameService.collectName(param);
		return HttpResult.success();
	}
	
	@ApiOperation("获取收藏列表")
	@GetMapping("collections/list")
	public HttpResult<List<NameVO>> getCollectNames(@RequestParam String userId) {
		return HttpResult.success(nameService.getCollectNameList(userId));
	}
}
