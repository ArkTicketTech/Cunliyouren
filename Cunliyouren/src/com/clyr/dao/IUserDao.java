package com.clyr.dao;

import java.util.ArrayList;

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
	 * 条件查询只能筛选出同高中大学，工作地居住地附近的需要通过高德地图api进一步筛选
	 * @param u
	 */
	ArrayList<User> select(User u);
}
