package com.clyr.dao;

import com.clyr.domain.User;

public interface IUserDao {
	/**
	 * ����û���Ϣ
	 * �����û���һ�ε�¼
	 * @param u
	 */
	void add(User u);
	/**
	 * �����û���Ϣ
	 * �����û����¸�����Ϣ
	 * @param u
	 */
	void update(User u);
	/**
	 * ��ѯ�û�
	 * ���ڲ�Ʒ����������ɸѡ�Լ���̨��ѯ�û�
	 * @param u
	 */
	void select(User u);
}
