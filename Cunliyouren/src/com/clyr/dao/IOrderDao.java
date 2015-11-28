package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.Order;

public interface IOrderDao {
	/**
	 * 添加订单
	 * 用于创建一次订购
	 * @param ord
	 */
	void add(Order ord);
	
	/**
	 * 删除订单（未实现）
	 * @param id
	 */
	void delete(int oId);
	
	/**
	 * 根据买家id筛选订单
	 * 用于显示发送的购买请求
	 * @param Id
	 * @return
	 */
	ArrayList<Order> selectByBuyer(int bId);
	
	/**
	 * 根据卖家id筛选订单
	 * 用于显示收到的购买请求
	 * @param Id
	 * @return
	 */
	ArrayList<Order> selectBySeller(int sId);
}
