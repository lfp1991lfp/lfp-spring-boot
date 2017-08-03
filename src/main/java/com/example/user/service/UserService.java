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
	 * @return
	 */
	Page<UserInfo> findByPage(int pageNo, int pageSize);
	
	void insert(UserInfo person);
}
