package com.example.user.service;

import com.example.user.model.UserInfo;
import com.example.user.model.mapper.UserInfoMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现层
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	
	private final UserInfoMapper userInfoMapper;
	
	@Autowired
	public UserServiceImpl(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}
	
	@Override
	public List<UserInfo> findAll() {
		PageHelper.startPage(1, 2);
		return userInfoMapper.selectAll();
	}
	
	@Override
	public Page<UserInfo> findByPage(int pageNo, int pageSize) {
		Page<UserInfo> page = PageHelper.startPage(pageNo, pageSize);
		userInfoMapper.selectAll();
		return page;
	}
	
	@Override
	public void insert(UserInfo person) {
	
	}
}
