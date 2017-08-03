package com.example.user.controller;

import com.example.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器.
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "用户管理", tags = {"用户管理API"}, description = "描述信息")
public class UserController {
	
	private final Environment env;
	
	@Autowired
	public UserController(Environment env) {
		this.env = env;
	}
	
	@ApiOperation(value = "查询用户", notes = "查询用户notes", produces = "application/json")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User view(@ApiParam(value = "用户参数") @PathVariable("id") Long id) {
		User user = new User();
		user.setId(id);
		user.setName("lfp");
		
		log.info("启动spring-boot，当前环境为" + env.getActiveProfiles()[0]);
		log.debug("success");
		return user;
	}
	
}
