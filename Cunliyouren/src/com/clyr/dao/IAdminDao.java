package com.clyr.dao;

import com.clyr.domain.Admin;

public interface IAdminDao {
	/**
	 * @param adminName
	 * @param password
	 * @return
	 */
	Admin checkAdmin(String adminName, String password);
	
	/**
	 * @param adminName
	 * @param password
	 */
	void update(Admin admin);
}
