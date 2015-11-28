package com.clyr.dao;

import com.clyr.domain.Admin;

public interface IAdminDao {
	/**
	 * 根据adminName查找对应的password
	 * 用于处理管理员登陆，管理员修改密码验证
	 * @param adminName
	 * @param password
	 * @return
	 */
	Admin checkAdmin(String adminName, String password);
	
	/**
	 * 根据adminName修改对应的password
	 * 用于admin的密码修改
	 * @param adminName
	 * @param password
	 */
	void update(Admin admin);
}
