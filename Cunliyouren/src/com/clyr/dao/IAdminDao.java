package com.clyr.dao;

import com.clyr.domain.Admin;

public interface IAdminDao {
	/**
	 * ����adminName���Ҷ�Ӧ��password
	 * ���ڴ������Ա��½������Ա�޸�������֤
	 * @param adminName
	 * @param password
	 * @return
	 */
	Admin checkAdmin(String adminName, String password);
	
	/**
	 * ����adminName�޸Ķ�Ӧ��password
	 * ����admin�������޸�
	 * @param adminName
	 * @param password
	 */
	void update(Admin admin);
}
