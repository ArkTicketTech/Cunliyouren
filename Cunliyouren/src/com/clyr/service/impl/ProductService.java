package com.clyr.service.impl;

import java.util.ArrayList;

import com.clyr.dao.IProductDao;
import com.clyr.dao.impl.ProductDao;
import com.clyr.domain.Product;
import com.clyr.service.IProductService;

public class ProductService implements IProductService{
	private IProductDao productDao=new ProductDao();
	
	@Override
	public void uploadProduct(Product pro) {
		productDao.add(pro);
	}

	@Override
	public void deleteProduct(int pId) {
		productDao.delete(pId);
	}

	@Override
	public ArrayList<Product> searchByProductName(String productName) {
		ArrayList<Product> a=new ArrayList<Product>();
		a.addAll(productDao.selectByName(productName));
		a.addAll(productDao.fuzzySelectByName(productName));
		return null;
	}

	@Override
	public ArrayList<Product> myProduct(int uId) {
		int pId;
		ArrayList<Product> a=new ArrayList<Product>();
		return a;
	}

}
