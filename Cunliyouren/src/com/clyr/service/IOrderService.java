package com.clyr.service;

import java.util.ArrayList;

import com.clyr.domain.Order;

public interface IOrderService {
	/**
	 * @param ord
	 * @return
	 */
	void createOrder(Order ord);
	
	/**
	 * @param Id
	 * @return
	 */
	ArrayList<Order> SendedOrder(int uId);
	
	/**
	 * @param Id
	 * @return
	 */
	ArrayList<Order> ReceivedOrder(int uId);
}
