package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.User;

public interface IUserDao {
	/**
	 * 添加新用户
	 * @param u
	 */
	void add(User u);
	/**
	 * 更新用户信息
	 * @param u
	 */
	void update(User u);
	/**
	 * 查找用户
	 * @param u
	 */
	ArrayList<User> select(User u);
	/**
	 * 根据id查找用户
	 * @param u
	 */
	User selectByUId(int uId);
}
