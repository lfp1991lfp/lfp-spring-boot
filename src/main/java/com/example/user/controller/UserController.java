package com.example.user.controller;

import com.example.user.model.UserInfo;
import com.example.user.service.UserService;
import com.example.user.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器.
 */
@RestController
@RequestMapping("/user/")
@Slf4j
@Api(value = "用户管理", tags = {"user"},
		description = "用户管理", produces = "application/json")
public class UserController {

	private final Environment env;
	private final UserService userService;

	@Autowired
	public UserController(Environment env, UserServiceImpl userService) {
		this.env = env;
		this.userService = userService;
	}

	@ApiOperation(value = "查询用户", notes = "查询用户notes", produces = "application/json")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public UserInfo view(@ApiParam(value = "用户参数") @PathVariable("id") int id) {
		log.info("启动spring-boot，当前环境为" + env.getActiveProfiles()[0]);
		log.debug("success");

		return userService.findUserById(id);
	}

	@ApiOperation(value = "获取所有用户的信息", produces = "application/json")
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<UserInfo> userList() {
		return userService.findAll();
	}

	@ApiOperation(value = "分页查询用户信息", response = UserInfo.class,
			notes = "index小标从1开始,为0表示查询所有用户", produces = "application/json")
	@RequestMapping(value = "page", method = RequestMethod.GET)
	@ResponseBody
	public List<UserInfo> page(@ApiParam(name = "page", value = "页数索引")
														 @RequestParam(defaultValue = "1") int page,
														 @ApiParam(name = "size", value = "页码")
														 @RequestParam(defaultValue = "1") int size) {
		return userService.findByPage(page, size);
	}

	@ApiOperation(value = "获取用户的信息", produces = "application/json")
	@RequestMapping(value = "findModel", method = RequestMethod.GET)
	public List<UserInfo> findModel(UserInfo userInfo) {
		return userService.finByModel(userInfo);
	}
}
