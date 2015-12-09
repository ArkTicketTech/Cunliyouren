package com.clyr.dao.impl;

import java.util.ArrayList;

import com.clyr.domain.Product;
import com.clyr.domain.User;

public class DaoTest {
	public static void main(String args[])
	{
		ProductDao pd=new ProductDao();
		ArrayList<Product> a=pd.fuzzySelectByName("p");
		for(Product p:a)
		{
			System.out.println(p.getUpdateTime());
		}
	}
}
