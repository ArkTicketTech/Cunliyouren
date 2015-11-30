package com.clyr.dao;

import java.util.ArrayList;

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
	 * ������ѯֻ��ɸѡ��ͬ���д�ѧ�������ؾ�ס�ظ�������Ҫͨ���ߵµ�ͼapi��һ��ɸѡ
	 * @param u
	 */
	ArrayList<User> select(User u);
}
