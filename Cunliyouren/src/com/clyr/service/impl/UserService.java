package com.clyr.service.impl;

import java.util.ArrayList;

import com.clyr.dao.IOrderDao;
import com.clyr.dao.IProductDao;
import com.clyr.dao.IUserDao;
import com.clyr.dao.impl.OrderDao;
import com.clyr.dao.impl.ProductDao;
import com.clyr.dao.impl.UserDao;
import com.clyr.domain.Product;
import com.clyr.domain.User;
import com.clyr.service.IUserService;

public class UserService implements IUserService{
	private IUserDao userDao=new UserDao();
	private IProductDao productDao=new ProductDao();
	private IOrderDao orderDao = new OrderDao();
	@Override
	public void register(User u) {
		userDao.add(u);
	}

	@Override
	public boolean login(User u) {
		ArrayList<User> a=userDao.select(u);
		if(a.size()<1)
			return false;
		else 
			return true;
	}

	@Override
	public void update(User u) {
		userDao.update(u);
	}

	@Override
	public void enable(User u) {
		u.setState(1);
		userDao.update(u);
	}

	@Override
	public void disable(User u) {
		u.setState(0);
		userDao.update(u);
	}

	@Override
	public ArrayList<User> search(String key) {
		User t_u=new User();
		ArrayList<User> a=userDao.select(t_u);
		boolean flag=true;
		for(int i=0;i<a.size();i++)
		{
			t_u=a.get(i);
			flag=true;
			if(t_u.getNickName().equals(key)||t_u.getTelNum().equals(key)||t_u.getHighSchool().equals(key)
					||t_u.getHomeAddress().equals(key)||t_u.getHomeTown().equals(key)||t_u.getUniversity().equals(key)
					||t_u.getWorkingAddress().equals(key))
				flag=false;
			if(flag)
				a.remove(i);	
			else
			{
				int uid=t_u.getuId();
				ArrayList<Product> a_p=productDao.selectByuId(uid);
				if(a_p!=null)
				{
					ArrayList<Integer> a_i=new ArrayList<Integer>();
					for(Product p:a_p)
					{
						a_i.add(p.getpId());
					}
					t_u.setPid(a_i);
				}
				t_u.setSendOrder(orderDao.selectByBuyer(uid).size());
				t_u.setReceiveOrder(orderDao.selectBySeller(uid).size());
			}
		}
		return a;
	}

}
