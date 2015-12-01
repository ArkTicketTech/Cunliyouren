package com.clyr.service;

import com.clyr.domain.User;

public interface IUserService {
	/**
	 * 提供第一次登录存储用户信息服务
	 * @param u
	 */
	void register(User u);
	/**
	 * 提供登录服务
	 * @param u
	 */
	void login(User u);
	/**
	 * 提供个人信息更新服务
	 * @param u
	 */
	void update(User u);
	/**
	 * 提供启用用户服务
	 * @param u
	 */
	void enable(User u);
	/**
	 * 提供停用用户服务
	 * @param u
	 */
	void disable(User u);
}
