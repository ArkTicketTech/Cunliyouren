package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.Product;

public interface IProductDao {
	/**
	 * ��Ӳ�Ʒ��Ϣ
	 * @param pro
	 */
	void add(Product pro);
	/**
	 * ���ݲ�Ʒ���ɾ��ӵ�в�Ʒ
	 * @param id
	 */
	void delete(int pId);
	/**
	 * ���²�Ʒ��Ϣ
	 * ���ڶ����ϴ���Ʒ��Ϣ
	 * @param pro
	 */
	void update(Product pro);
	/**
	 * ���ݲ�Ʒ���Ʋ��Ҳ�Ʒ
	 * ���ھ�ȷ������Ʒ
	 * @param productName
	 * @return
	 */
	ArrayList<Product> selectByName(String productName);
	/**
	 * ���ݲ�Ʒid���Ҳ�Ʒ
	 * �����ҵĵ�����ʾ
	 * @param id
	 * @return
	 */
	Product selectById(int pId);
    /**
     * ���ݲ�Ʒ����ģ�����Ҳ�Ʒ
     * ����ģ�����Ҳ�Ʒ
     * @return
     */
	ArrayList<Product> fuzzySelectByName(String productName);
}
