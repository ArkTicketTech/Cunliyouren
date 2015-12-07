package com.clyr.service.impl;

import java.util.ArrayList;

import com.clyr.dao.IProductDao;
import com.clyr.dao.IUserDao;
import com.clyr.dao.impl.ProductDao;
import com.clyr.dao.impl.UserDao;
import com.clyr.domain.Product;
import com.clyr.domain.User;
import com.clyr.service.IProductService;

public class ProductService implements IProductService{
	private IProductDao productDao=new ProductDao();
	private IUserDao userDao=new UserDao();
	
	@Override
	public void uploadProduct(Product pro) {
		productDao.add(pro);
	}

	@Override
	public void deleteProduct(int pId) {
		productDao.delete(pId);
	}

	@Override
	public ArrayList<Product> searchByProductName(String productName, User u) {
		ArrayList<Product> a=new ArrayList<Product>();
		ArrayList<User> temp=userDao.select(u);
		boolean flag=true;
		a.addAll(productDao.selectByName(productName));
		a.addAll(productDao.fuzzySelectByName(productName));
		for(Product p:a)
		{
			flag=true;
			for(User t_u:temp)
			{
				if(p.getOwnerId()==t_u.getuId()) flag=false;
			}
			if(flag)
				a.remove(p);
		}
		return a;
	}

	@Override
	public ArrayList<Product> myProduct(int uId) {
		ArrayList<Product> a=productDao.selectByuId(uId);
		return a;
	}

	@Override
	public Product searchByPId(int pId) {
		Product p=productDao.selectById(pId);
		return p;
	}
}
