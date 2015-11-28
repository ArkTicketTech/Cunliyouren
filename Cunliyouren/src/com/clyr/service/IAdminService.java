package com.clyr.service;

import com.clyr.domain.Admin;

public interface IAdminService {
	/**
	 * 提供管理员登录服务
	 * @param adminName
	 * @param password
	 * @return
	 */
	Admin loginAdmin(String adminName, String password);
	
	/**
	 * 提供修改管理员密码服务
	 * @param adminName
	 * @param password
	 */
	void modifyAdminPassword(String adminName, String password);
}
