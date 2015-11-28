package com.clyr.service.impl;

import com.clyr.dao.IAdminDao;
import com.clyr.dao.impl.AdminDao;
import com.clyr.domain.Admin;
import com.clyr.service.IAdminService;

public class AdminService implements IAdminService{
	
	private IAdminDao adminDao = new AdminDao();

	@Override
	public Admin loginAdmin(String adminName, String password) {
		return adminDao.checkAdmin(adminName, password);
	}

	@Override
	public boolean modifyAdminPassword(String adminName, String oldPassword , String newPassword) {
		if(adminDao.checkAdmin(adminName, oldPassword)==null) return false;
		Admin a=new Admin();
		a.setAdminName(adminName);
		a.setPassword(newPassword);
		adminDao.update(a);
		return true;
	}

}
