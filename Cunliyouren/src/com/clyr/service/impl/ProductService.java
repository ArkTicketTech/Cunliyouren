package com.clyr.service.impl;

import java.util.ArrayList;

import com.clyr.dao.IProductDao;
import com.clyr.dao.IUserDao;
import com.clyr.dao.impl.ProductDao;
import com.clyr.dao.impl.UserDao;
import com.clyr.domain.Product;
import com.clyr.domain.User;
import com.clyr.service.IProductService;
import com.clyr.utils.AMapUtils;

public class ProductService implements IProductService {
	private IProductDao productDao = new ProductDao();
	private IUserDao userDao = new UserDao();

	@Override
	public void uploadProduct(Product pro) {
		productDao.add(pro);
	}
	
	@Override
	public void updateProduct(Product pro) {
		productDao.update(pro);
	}

	@Override
	public void deleteProduct(int pId) {
		productDao.delete(pId);
	}

	@Override
	public ArrayList<Product> searchByProductName(String productName) {
		ArrayList<Product> a = new ArrayList<Product>();
		a.addAll(productDao.selectByName(productName));
		a.addAll(productDao.fuzzySelectByName(productName));
		return a;
	}

	@Override
	public ArrayList<Product> myProduct(int uId) {
		ArrayList<Product> a = productDao.selectByuId(uId);
		return a;
	}

	@Override
	public Product searchByPId(int pId) {
		Product p = productDao.selectById(pId);
		return p;
	}

	@Override
	public ArrayList<Product> addConstraint(ArrayList<Product> a,
			String constrain, User u) {
		ArrayList<Product> result=new  ArrayList<Product>();
		if(constrain.equals("homeTown"))
		{
			for(Product p:a)
			{
				if(userDao.selectByUId(p.getOwnerId()).getHomeTown().equals(u.getHomeTown()))
					result.add(p);
			}
		}
		else if(constrain.equals("school"))
		{
			for(Product p:a)
			{
				if(userDao.selectByUId(p.getOwnerId()).getHighSchool().equals(u.getHighSchool()) || 
						userDao.selectByUId(p.getOwnerId()).getUniversity().equals(u.getUniversity()))
					result.add(p);
			}
		}
		else if(constrain.equals("homeAdd"))
		{
			for(Product p:a)
			{
				if(AMapUtils.Distance(userDao.selectByUId(p.getOwnerId()).getHomeAddressLocation(), u.getHomeAddressLocation())<3000)
					result.add(p);
			}
		}
		else if(constrain.equals("workAdd"))
		{
			for(Product p:a)
			{
				if(AMapUtils.Distance(userDao.selectByUId(p.getOwnerId()).getWorkingAddressLocation(), u.getWorkingAddressLocation())<3000)
					result.add(p);
			}
		}
		else
		{ 
			return a;
		}
		return result;
	}
	

}

