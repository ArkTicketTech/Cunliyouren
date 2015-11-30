package com.clyr.dao;

import com.clyr.domain.User;

public interface IUserDao {
	/**
	 * 添加用户信息
	 * 用于用户第一次登录
	 * @param u
	 */
	void add(User u);
	/**
	 * 更新用户信息
	 * 用于用户更新个人信息
	 * @param u
	 */
	void update(User u);
	/**
	 * 查询用户
	 * 用于产品搜索的条件筛选以及后台查询用户
	 * @param u
	 */
	void select(User u);
}
