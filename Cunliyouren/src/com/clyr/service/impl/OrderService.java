package com.clyr.service.impl;

import java.util.ArrayList;

import com.clyr.dao.IOrderDao;
import com.clyr.dao.impl.OrderDao;
import com.clyr.domain.Order;
import com.clyr.service.IOrderService;

public class OrderService implements IOrderService{
	private IOrderDao adminDao = new OrderDao();

	@Override
	public void createOrder(Order ord) {
		adminDao.add(ord);
	}

	@Override
	public ArrayList<Order> SendedOrder(int uId) {
		return adminDao.selectByBuyer(uId);
	}

	@Override
	public ArrayList<Order> ReceivedOrder(int uId) {
		return adminDao.selectBySeller(uId);
	}

}
