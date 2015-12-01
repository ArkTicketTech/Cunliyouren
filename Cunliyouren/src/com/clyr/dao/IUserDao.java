package com.clyr.dao;

import java.util.ArrayList;

import com.clyr.domain.User;

public interface IUserDao {
	/**
	 * @param u
	 */
	void add(User u);
	/**
	 * @param u
	 */
	void update(User u);
	/**
	 * @param u
	 */
	ArrayList<User> select(User u);
}
