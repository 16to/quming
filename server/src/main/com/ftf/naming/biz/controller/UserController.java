package com.ftf.naming.biz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftf.naming.biz.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user/")
@Api("用户接口")
public class UserController {

	@ApiOperation("获取用户列表")
	@GetMapping("list")
	public List<UserVO> listUsers(){
		List<UserVO> userList = new ArrayList<UserVO>();
		userList.add(new UserVO("1","剑圣","123456789"));
		userList.add(new UserVO("2","猩猩","123456789"));
		userList.add(new UserVO("3","贱宁","123456789"));
		userList.add(new UserVO("4","凯子","123456789"));
		return userList;
	}
}
