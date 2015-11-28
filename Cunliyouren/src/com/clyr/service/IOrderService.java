package com.clyr.service;

import java.util.ArrayList;

import com.clyr.domain.Order;

public interface IOrderService {
	/**
	 * �ṩ�µ�����
	 * @param ord
	 * @return
	 */
	Order createOrder(Order ord);
	
	/**
	 * �ṩ�鿴���͵Ĺ����������
	 * @param Id
	 * @return
	 */
	ArrayList<Order> SendedOrder(int uId);
	
	/**
	 * �ṩ�鿴�յ��Ĺ����������
	 * @param Id
	 * @return
	 */
	ArrayList<Order> ReceivedOrder(int uId);
}
