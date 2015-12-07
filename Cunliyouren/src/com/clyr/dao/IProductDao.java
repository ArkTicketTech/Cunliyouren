package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.Product;

public interface IProductDao {
	/**
	 * 添加产品 用于添加产品信息服务
	 * 
	 * @param pro
	 */
	void add(Product pro);

	/**
	 * 产出产品 用于删除产品服务
	 * 
	 * @param id
	 */
	void delete(int pId);

	/**
	 * 更新产品 用于保存产品服务
	 * 
	 * @param pro
	 */
	void update(Product pro);

	/**
	 * 根据产品名精确查找
	 * 
	 * @param productName
	 * @return
	 */
	ArrayList<Product> selectByName(String productName);

	/**
	 * 根据pid查找
	 * 
	 * @param id
	 * @return
	 */
	Product selectById(int pId);

	/**
	 * 根据产品名模糊查找
	 * 
	 * @return
	 */
	ArrayList<Product> fuzzySelectByName(String productName);

	/**
	 * 根据uid查找
	 * 
	 * @param id
	 * @return
	 */
	ArrayList<Product> selectByuId(int uId);
}
