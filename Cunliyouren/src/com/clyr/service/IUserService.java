package com.clyr.service;

import com.clyr.domain.User;

public interface IUserService {
	/**
	 * 提供新用户注册服务
	 * @param u
	 */
	void register(User u);
	/**
	 * 提供用户登录验证服务
	 * @param u
	 */
	void login(User u);
	/**
	 * 提供用户更新个人信息服务
	 * @param u
	 */
	void update(User u);
	/**
	 * 提供后台启用用户服务
	 * @param u
	 */
	void enable(User u);
	/**
	 * 提供后台停用用户服务
	 * @param u
	 */
	void disable(User u);
}
