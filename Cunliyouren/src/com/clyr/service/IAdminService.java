package com.clyr.service;

import com.clyr.domain.Admin;

public interface IAdminService {
	/**
	 * �ṩ����Ա��¼����
	 * @param adminName
	 * @param password
	 * @return
	 */
	Admin loginAdmin(String adminName, String password);
	
	/**
	 * �ṩ�޸Ĺ���Ա�������
	 * @param adminName
	 * @param password
	 */
	boolean modifyAdminPassword(String adminName, String oldPassword , String newPassword);
}