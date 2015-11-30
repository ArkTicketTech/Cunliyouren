package com.clyr.service;

import com.clyr.domain.User;

public interface IUserService {
	/**
	 * �ṩ���û�ע�����
	 * @param u
	 */
	void register(User u);
	/**
	 * �ṩ�û���¼��֤����
	 * @param u
	 */
	void login(User u);
	/**
	 * �ṩ�û����¸�����Ϣ����
	 * @param u
	 */
	void update(User u);
	/**
	 * �ṩ��̨�����û�����
	 * @param u
	 */
	void enable(User u);
	/**
	 * �ṩ��̨ͣ���û�����
	 * @param u
	 */
	void disable(User u);
}
