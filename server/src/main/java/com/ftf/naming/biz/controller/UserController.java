package com.ftf.naming.biz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftf.naming.biz.HttpResult;
import com.ftf.naming.biz.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user/")
@Api(tags="用户模块")
public class UserController {

	@ApiOperation("获取用户信息")
	@GetMapping("info")
	@ApiImplicitParam(name="phone",value="手机号",required=true)
	public HttpResult<UserVO> userInfo(@RequestParam String phone){
		return HttpResult.success(new UserVO("2","猩猩","123456789"));
	}
	
	@ApiOperation("登录")
	@PostMapping("login")
	public HttpResult login(){
		return HttpResult.success();
	}
}
