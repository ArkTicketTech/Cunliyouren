package com.clyr.service;

import com.clyr.domain.Admin;

public interface IAdminService {
	/**
	 * @param adminName
	 * @param password
	 * @return
	 */
	Admin loginAdmin(String adminName, String password);
	
	/**
	 * @param adminName
	 * @param password
	 */
	boolean modifyAdminPassword(String adminName, String oldPassword , String newPassword);
}
