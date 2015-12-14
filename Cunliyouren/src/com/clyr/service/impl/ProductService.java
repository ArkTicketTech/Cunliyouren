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
			String constrain , User u) {
		ArrayList<Product> result=new ArrayList<Product>();
		System.out.println(constrain);
		boolean flag=false;
		for(Product p: a)
		{
			flag=false;
			if(constrain.equals("homeTown"))
			{
				if(userDao.selectByUId(p.getOwnerId()).getHomeTown().equals(u.getHomeTown()))
				{
					flag=true;
				}
			}
			if(constrain.equals("school"))
			{
				if(userDao.selectByUId(p.getOwnerId()).getHighSchool().equals(u.getHighSchool()) || 
						userDao.selectByUId(p.getOwnerId()).getUniversity().equals(u.getUniversity()))
				{
					flag=true;
				}
			}
			if(constrain.equals("homeAdd"))
			{
				if(AMapUtils.Distance(userDao.selectByUId(p.getOwnerId()).getHomeAddressLocation(), u.getHomeAddressLocation())<3000)
				{
					flag=true;
				}
			}
			if(constrain.equals("workAdd"))
			{
				if(AMapUtils.Distance(userDao.selectByUId(p.getOwnerId()).getWorkingAddressLocation(), u.getWorkingAddressLocation())<3000)
				{
					flag=true;
				}
			}
			System.out.println(flag);
			if(flag)
				result.add(p);
		}
		
		return result;
	}
	

}

