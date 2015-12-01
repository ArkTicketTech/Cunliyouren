package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.Product;

public interface IProductDao {
	/**
	 * @param pro
	 */
	void add(Product pro);
	/**
	 * @param id
	 */
	void delete(int pId);
	/**
	 * @param pro
	 */
	void update(Product pro);
	/**
	 * @param productName
	 * @return
	 */
	ArrayList<Product> selectByName(String productName);
	/**
	 * @param id
	 * @return
	 */
	Product selectById(int pId);
    /**
     * @return
     */
	ArrayList<Product> fuzzySelectByName(String productName);
}
