package com.clyr.service;

import java.util.ArrayList;

import com.clyr.domain.Order;

public interface IOrderService {
	/**
	 * 提供下单服务
	 * @param ord
	 * @return
	 */
	Order createOrder(Order ord);
	
	/**
	 * 提供查看发送的购买请求服务
	 * @param Id
	 * @return
	 */
	ArrayList<Order> SendedOrder(int uId);
	
	/**
	 * 提供查看收到的购买请求服务
	 * @param Id
	 * @return
	 */
	ArrayList<Order> ReceivedOrder(int uId);
}
