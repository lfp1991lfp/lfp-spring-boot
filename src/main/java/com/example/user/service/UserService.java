package com.example.user.service;

import com.example.user.model.UserInfo;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 服务层
 */
public interface UserService {
	
	List<UserInfo> findAll();
	
	/**
	 * 分页查询
	 *
	 * @param pageNo   页号
	 * @param pageSize 每页显示记录数
	 * @return 查询的用户信息
	 */
	Page<UserInfo> findByPage(int pageNo, int pageSize);
	
	/**
	 * 根据用户ID查询指定用户
	 *
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	UserInfo findUserById(int userId);
	void insert(UserInfo person);
}
