package com.clyr.service;

import java.util.ArrayList;

import com.clyr.domain.Product;
import com.clyr.domain.User;

public interface IProductService {
	/**
	 * 提供上传产品信息服务
	 * @param pro
	 * @return
	 */
	void uploadProduct(Product pro);
	
	/**
	 * 提供删除产品服务
	 * @param id
	 */
	void deleteProduct(int pId);
	
	/**
	 * 提供搜索产品服务
	 * @param productName
	 * @return
	 */
	ArrayList<Product> searchByProductName(String productName,User u);
	
	/**
	 * 提供我的店铺产品显示服务
	 * @param uId
	 * @return
	 */
	ArrayList<Product> myProduct(int uId);
}
