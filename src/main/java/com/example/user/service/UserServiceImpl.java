package com.example.user.service;

import com.example.model.UserInfo;
import com.example.model.mapper.UserDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
	
	private final UserDao userInfoDao;
	
	@Autowired
	public UserServiceImpl(UserDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
	@Override
	@Cacheable(cacheNames = "user")
	public List<UserInfo> findAll() {
		PageHelper.startPage(1, 10);
		return userInfoDao.selectAll();
	}
	
	@Override
	@Cacheable(cacheNames = "user")
	public Page<UserInfo> findByPage(int pageNo, int pageSize) {
		Page<UserInfo> page = PageHelper.startPage(pageNo, pageSize);
		userInfoDao.selectAll();
		return page;
	}
	
	@Override
	@Cacheable(cacheNames = "user", key = "#p0 + \"\"")   //缓存集合名为user,key取第一个参数作为默认key
	public UserInfo findUserById(int userId) {
		return userInfoDao.selectByPrimaryKey(userId);
	}
	
	@Override
	@Cacheable(cacheNames = "user", key = "#userInfo.id + \"\"")          //缓存的集合
	public Page<UserInfo> finByModel(UserInfo userInfo) {
		Page<UserInfo> page = PageHelper.startPage(userInfo.getIndex(), userInfo.getRow());
		userInfoDao.select(userInfo);
		return page;
	}
	
	@Override
	@CachePut(cacheNames = "user", key = "#userInfo.id + \"\"")   //插入成功，生成缓存数据
	public UserInfo insert(UserInfo userInfo) {
		userInfoDao.insert(userInfo);
		return userInfo;  //insert只返回响应行数,主键插入到model里面
	}
	
	@Override
	@CacheEvict(cacheNames = "user", key = "#p0 + \"\"")       //更新成功，清除缓存数据
	public UserInfo update(int id, UserInfo userInfo) {
		userInfo.setId(id);
		userInfoDao.updateByPrimaryKeySelective(userInfo);
		return userInfo;
	}
	
	@Override
	@CacheEvict(cacheNames = "user", key = "#p0 + \"\"")      //删除成功，清楚缓存
	public int deleteById(int id) {
		userInfoDao.deleteByPrimaryKey(id);
		return id;
	}
}
