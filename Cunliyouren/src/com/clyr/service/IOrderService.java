package com.clyr.service;

import java.util.ArrayList;

import com.clyr.domain.Order;

public interface IOrderService {
	/**
	 * 提供创建订单服务
	 * 
	 * @param ord
	 * @return
	 */
	void createOrder(Order ord);

	/**
	 * 提供已发送订单显示服务
	 * 
	 * @param Id
	 * @return
	 */
	ArrayList<Order> SendedOrder(int uId);

	/**
	 * 提供已收到订单显示服务
	 * 
	 * @param Id
	 * @return
	 */
	ArrayList<Order> ReceivedOrder(int uId);
}
