package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.Order;

public interface IOrderDao {
	/**
	 * ��Ӷ���
	 * ���ڴ���һ�ζ���
	 * @param ord
	 */
	void add(Order ord);
	
	/**
	 * ɾ��������δʵ�֣�
	 * @param id
	 */
	void delete(int oId);
	
	/**
	 * �������idɸѡ����
	 * ������ʾ���͵Ĺ�������
	 * @param Id
	 * @return
	 */
	ArrayList<Order> selectByBuyer(int bId);
	
	/**
	 * ��������idɸѡ����
	 * ������ʾ�յ��Ĺ�������
	 * @param Id
	 * @return
	 */
	ArrayList<Order> selectBySeller(int sId);
}
