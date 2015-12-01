package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.Order;

public interface IOrderDao {
	/**
	 * 添加订单
	 * 提供创建新订单服务
	 * @param ord
	 */
	void add(Order ord);
	
	/**
	 * 删除订单（未实现）
	 * @param id
	 */
	void delete(int oId);
	
	/**
	 * 通过卖家id查询订单
	 * 提供我收到的订单查询服务
	 * @param Id
	 * @return
	 */
	ArrayList<Order> selectByBuyer(int bId);
	
	/**
	 * 通过买家id查询订单
	 * 提供我发出的订单查询服务
	 * @param Id
	 * @return
	 */
	ArrayList<Order> selectBySeller(int sId);
}
