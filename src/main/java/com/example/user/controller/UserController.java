package com.example.user.controller;

import com.example.config.mvc.ApiVersion;
import com.example.user.model.UserInfo;
import com.example.user.service.UserService;
import com.example.user.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器.
 */
@RestController
@RequestMapping("/api/{version}/user/")
@Slf4j
@Api(value = "用户管理", tags = {"user"},
		description = "用户管理", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	
	private final Environment env;
	private final UserService userService;
	
	@Autowired
	public UserController(Environment env, UserServiceImpl userService) {
		this.env = env;
		this.userService = userService;
	}

//	@ApiOperation(value = "查询用户", notes = "查询用户notes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@GetMapping(value = "{id}")
//	@ApiVersion(1)
//	public UserInfo view(@ApiParam(value = "用户参数") @PathVariable("id") int id) {
//		log.info("启动spring-boot，当前环境为" + env.getActiveProfiles()[0]);
//		log.debug("success");
//
//		return userService.findUserById(id);
//	}
	
	@ApiOperation(value = "获取所有用户的信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@GetMapping(value = "list")
	@ApiVersion(1)
	public List<UserInfo> userList(@ApiVersion(1) @PathVariable("version") String version) {
		return userService.findAll();
	}

//	@ApiOperation(value = "分页查询用户信息", response = UserInfo.class,
//			notes = "index小标从1开始,为0表示查询所有用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@GetMapping(value = "page")
//	@ApiVersion(1)
//	public List<UserInfo> page(@ApiParam(name = "page", value = "页数索引")
//	                           @RequestParam(defaultValue = "1") int page,
//	                           @ApiParam(name = "size", value = "页码")
//	                           @RequestParam(defaultValue = "1") int size) {
//		return userService.findByPage(page, size);
//	}
//
//	@ApiOperation(value = "获取用户的信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@GetMapping(value = "findModel")
//	@ApiVersion(1)
//	public List<UserInfo> findModel(UserInfo userInfo) {
//		return userService.finByModel(userInfo);
//	}
//
//	@ApiOperation(value = "创建用户的信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@PostMapping(value = "create")    //post属于新建资源，属于创建
//	@ResponseStatus(code = HttpStatus.CREATED)
//	@ApiVersion(1)
//	public UserInfo create(@RequestBody UserInfo userInfo) {
//		return userService.insert(userInfo);
//	}
//
//	@ApiOperation(value = "更新用户的信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@PutMapping(value = "update/{id}")
//	@ResponseStatus(code = HttpStatus.OK)
//	@ApiVersion(1)
//	public UserInfo update(@PathVariable("id") int id, @RequestBody UserInfo userInfo) {
//		return userService.update(id, userInfo);
//	}
}
