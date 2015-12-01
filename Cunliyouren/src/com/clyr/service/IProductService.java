package com.clyr.service;

import java.util.ArrayList;

import com.clyr.domain.Product;
import com.clyr.domain.User;

public interface IProductService {
	/**
	 * @param pro
	 * @return
	 */
	void uploadProduct(Product pro);
	
	/**
	 * @param id
	 */
	void deleteProduct(int pId);
	
	/**
	 * @param productName
	 * @return
	 */
	ArrayList<Product> searchByProductName(String productName,User u);
	
	/**
	 * @param uId
	 * @return
	 */
	ArrayList<Product> myProduct(int uId);
}
