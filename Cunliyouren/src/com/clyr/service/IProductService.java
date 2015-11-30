package com.clyr.service;

import java.util.ArrayList;

import com.clyr.domain.Product;
import com.clyr.domain.User;

public interface IProductService {
	/**
	 * �ṩ�ϴ���Ʒ��Ϣ����
	 * @param pro
	 * @return
	 */
	void uploadProduct(Product pro);
	
	/**
	 * �ṩɾ����Ʒ����
	 * @param id
	 */
	void deleteProduct(int pId);
	
	/**
	 * �ṩ������Ʒ����
	 * @param productName
	 * @return
	 */
	ArrayList<Product> searchByProductName(String productName,User u);
	
	/**
	 * �ṩ�ҵĵ��̲�Ʒ��ʾ����
	 * @param uId
	 * @return
	 */
	ArrayList<Product> myProduct(int uId);
}
