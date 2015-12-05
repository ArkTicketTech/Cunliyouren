package com.clyr.service;

import java.util.ArrayList;

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
	boolean login(User u);
	/**
	 * 提供个人信息更新服务
	 * @param u
	 */
	void update(User u);
	/**
	 * 提供个人信息查找服务
	 * @param u
	 */
	ArrayList<User> search(String key);
	/**
	 * 提供用户id查找用户服务
	 * @param u
	 */
	User searchByUId(int uId);
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
