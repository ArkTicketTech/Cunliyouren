package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.Order;

public interface IOrderDao {
	/**
	 * @param ord
	 */
	void add(Order ord);
	
	/**
	 * @param id
	 */
	void delete(int oId);
	
	/**
	 * @param Id
	 * @return
	 */
	ArrayList<Order> selectByBuyer(int bId);
	
	/**
	 * @param Id
	 * @return
	 */
	ArrayList<Order> selectBySeller(int sId);
}
