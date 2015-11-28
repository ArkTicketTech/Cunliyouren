package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.Product;

public interface IProductDao {
	/**
	 * 添加产品信息
	 * @param pro
	 */
	void add(Product pro);
	/**
	 * 根据产品编号删除拥有产品
	 * @param id
	 */
	void delete(int id);
	/**
	 * 更新产品信息
	 * 用于二次上传产品信息
	 * @param pro
	 */
	void update(Product pro);
	/**
	 * 根据产品名称查找产品
	 * 用于搜索产品
	 * @param productName
	 * @return
	 */
	ArrayList<Product> selectByName(String productName);
	/**
	 * 根据产品id查找产品
	 * 用于我的店铺显示
	 * @param id
	 * @return
	 */
	Product selectById(int pId);
}
