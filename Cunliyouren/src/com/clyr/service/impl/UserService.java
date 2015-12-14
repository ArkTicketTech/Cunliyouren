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

public class UserService implements IUserService {
	private IUserDao userDao = new UserDao();
	private IProductDao productDao = new ProductDao();
	private IOrderDao orderDao = new OrderDao();

	@Override
	public void register(User u) {
		userDao.add(u);
	}

	@Override
	public boolean login(User u) {
		ArrayList<User> a = userDao.select(u);
		if (a.size() < 1)
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
		User t_u = new User();
		ArrayList<User> a = userDao.select(t_u);
		ArrayList<Product> a_pp=productDao.selectByName(key);
		boolean flag = true;
		for (int i = 0; i < a.size(); i++) {
			t_u = a.get(i);
			flag = true;
			if(a_pp!=null)
			{
				for(Product p:a_pp)
				{
					if(p.getOwnerId()==t_u.getuId())
						flag=false;
				}
			}
			if (key.equals("") || t_u.getNickName().equals(key)
					|| t_u.getTelNum().equals(key)
					|| t_u.getHighSchool().equals(key)
					|| t_u.getHomeAddress().equals(key)
					|| t_u.getHomeTown().equals(key)
					|| t_u.getUniversity().equals(key)
					|| t_u.getWorkingAddress().equals(key)
					)
				flag = false;
			if (flag) {
				a.remove(i);
				i--;
			} else {
				int uid = t_u.getuId();
				ArrayList<Product> a_p = productDao.selectByuId(uid);
				if (a_p != null) {
					ArrayList<Integer> a_i = new ArrayList<Integer>();
					ArrayList<String> a_s = new ArrayList<String>();
					for (Product p : a_p) {
						a_i.add(p.getpId());
						a_s.add(p.getProductName());
					}
					while (a_i.size() < 3) {
						a_i.add(0);
						a_s.add("");
					}
					t_u.setPid(a_i);
					t_u.setpName(a_s);
				}
				t_u.setSendOrder(orderDao.selectByBuyer(uid).size());
				t_u.setReceiveOrder(orderDao.selectBySeller(uid).size());
			}
		}
		return a;
	}

	@Override
	public User searchByUId(int uId) {
		return userDao.selectByUId(uId);
	}

	@Override
	public User searchByOpenId(String openId) {
		return userDao.selectByOpenId(openId);
	}
	
	@Override
	public User searchByAccessToken(String accessToken) {
		return userDao.selectByAccessToken(accessToken);
	}
}
