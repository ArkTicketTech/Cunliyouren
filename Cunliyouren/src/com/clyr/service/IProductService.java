package com.clyr.service;

import java.util.ArrayList;

import com.clyr.domain.Product;

public interface IProductService {
	/**
	 * �ṩ�ϴ���Ʒ��Ϣ����
	 * @param pro
	 * @return
	 */
	Product uploadProduct(Product pro);
	
	/**
	 * �ṩɾ����Ʒ����
	 * @param id
	 */
	void deleteProduct(int id);
	
	/**
	 * �ṩ������Ʒ����
	 * @param productName
	 * @return
	 */
	ArrayList<Product> searchByProductName(String productName);
	
	/**
	 * �ṩ�ҵĵ��̲�Ʒ��ʾ����
	 * @param uId
	 * @return
	 */
	ArrayList<Product> myProduct(int uId);
}
