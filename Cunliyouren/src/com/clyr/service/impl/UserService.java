package com.clyr.service.impl;

import java.util.ArrayList;

import com.clyr.dao.IUserDao;
import com.clyr.dao.impl.UserDao;
import com.clyr.domain.User;
import com.clyr.service.IUserService;

public class UserService implements IUserService{
	private IUserDao userDao=new UserDao();
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

}
