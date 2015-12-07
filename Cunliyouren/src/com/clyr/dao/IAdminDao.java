package com.clyr.dao;

import com.clyr.domain.Admin;

public interface IAdminDao {
	/**
	 * 管理员登录验证 用于管理员登录
	 * 
	 * @param adminName
	 * @param password
	 * @return
	 */
	Admin checkAdmin(String adminName, String password);

	/**
	 * 管理员数据更新 用于修改密码
	 * 
	 * @param adminName
	 * @param password
	 */
	void update(Admin admin);
}
