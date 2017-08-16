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
 * 服务实现层.
 * Transactional表示事务管理器，若在类的头部声明，则表示
 * 整个类都是事务声明，事务精确到方法体
 */
@Service
@Transactional(value = "txPrimaryManager")
public class UserServiceImpl implements UserService {
	
	private final UserInfoMapper userInfoMapper;
	
	@Autowired
	public UserServiceImpl(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}
	
	@Override
	public List<UserInfo> findAll() {
		PageHelper.startPage(1, 10);
		return userInfoMapper.selectAll();
	}
	
	@Override
	public Page<UserInfo> findByPage(int pageNo, int pageSize) {
		Page<UserInfo> page = PageHelper.startPage(pageNo, pageSize);
		userInfoMapper.selectAll();
		return page;
	}
	
	@Override
	public UserInfo findUserById(int userId) {
		return userInfoMapper.selectByPrimaryKey(userId);
	}
	
	@Override
	public Page<UserInfo> finByModel(UserInfo userInfo) {
		Page<UserInfo> page = PageHelper.startPage(userInfo.getIndex(), userInfo.getRow());
		userInfoMapper.select(userInfo);
		return page;
	}
	
	@Override
	public UserInfo insert(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
		return userInfo;  //insert只返回响应行数,主键插入到model里面
	}
	
	@Override
	public UserInfo update(int id, UserInfo userInfo) {
		userInfo.setId(id);
		userInfoMapper.updateByPrimaryKeySelective(userInfo);
		return userInfo;
	}
}
