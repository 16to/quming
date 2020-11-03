package com.ftf.naming.biz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftf.naming.biz.vo.NameVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/name/")
@Api("取名接口")
public class NameController {

	@ApiOperation("取名")
	@PostMapping("new")
	public NameVO newName() {
		return new NameVO("张","杰");
	}
}
