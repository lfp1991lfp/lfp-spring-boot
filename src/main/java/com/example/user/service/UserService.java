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
	 * 分页查询.
	 *
	 * @param pageNo   页号
	 * @param pageSize 每页显示记录数
	 * @return 查询的用户信息
	 */
	Page<UserInfo> findByPage(int pageNo, int pageSize);
	
	/**
	 * 根据用户ID查询指定用户.
	 *
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	UserInfo findUserById(int userId);
	
	/**
	 * 通过model属性查找对应信息.
	 *
	 * @param userInfo model
	 * @return model的分页信息
	 */
	Page<UserInfo> finByModel(UserInfo userInfo);
	
	/**
	 * 数据插入
	 *
	 * @param userInfo 保存的用户信息
	 * @return 新生成的用户信息
	 */
	UserInfo insert(UserInfo userInfo);
	
	/**
	 * 数据更新，若找不到数据，则插入数据
	 *
	 * @param id       用户id
	 * @param userInfo 需要插座的数据
	 * @return 操作后的数据
	 */
	UserInfo update(int id, UserInfo userInfo);
}
