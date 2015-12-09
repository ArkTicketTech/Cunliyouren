package com.clyr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.clyr.dao.IProductDao;

import com.clyr.domain.Product;
import com.clyr.utils.DBConn;

public class ProductDao implements IProductDao {

	@Override
	public void add(Product pro) {
		DBConn db = new DBConn();
		db.getConn();
		db.doInsert("insert into t_product values(null,'"
				+ pro.getProductName() + "'," + pro.getPrice() + ",'"
				+ pro.getUnit() + "','" + pro.getDescription() + "','"
				+ pro.getPicture1() + "','" + pro.getPicture2() + "','"
				+ pro.getPicture3() + "','" + pro.getDeliveryPoint() + "',"
				+ pro.getOwnerId() + ",null)");
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int pId) {
		DBConn db = new DBConn();
		db.getConn();
		db.doDelete("delete from t_product where pId=" + pId);
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Product pro) {
		DBConn db = new DBConn();
		db.getConn();
		if (!pro.getProductName().equals(""))
			db.doUpdate("update t_product set productName='"
					+ pro.getProductName() + "' where pId=" + pro.getpId());
		if (pro.getPrice() != 0)
			db.doUpdate("update t_product set price=" + pro.getPrice()
					+ " where pId=" + pro.getpId());
		if (pro.getOwnerId() != 0)
			db.doUpdate("update t_product set ownerId=" + pro.getOwnerId()
					+ " where pId=" + pro.getpId());
		if (!pro.getUnit().equals(""))
			db.doUpdate("update t_product set unit='" + pro.getUnit()
					+ "' where pId=" + pro.getpId());
		if (!pro.getDescription().equals(""))
			db.doUpdate("update t_product set description='"
					+ pro.getDescription() + "' where pId=" + pro.getpId());
		if (!pro.getPicture1().equals(""))
			db.doUpdate("update t_product set picture1='" + pro.getPicture1()
					+ "' where pId=" + pro.getpId());
		if (!pro.getPicture2().equals(""))
			db.doUpdate("update t_product set picture2='" + pro.getPicture2()
					+ "' where pId=" + pro.getpId());
		if (!pro.getPicture3().equals(""))
			db.doUpdate("update t_product set picture3='" + pro.getPicture3()
					+ "' where pId=" + pro.getpId());
		if (!pro.getDeliveryPoint().equals(""))
			db.doUpdate("update t_product set deliveryPoint='"
					+ pro.getDeliveryPoint() + "' where pId=" + pro.getpId());
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Product> selectByName(String productName) {
		DBConn db = new DBConn();
		db.getConn();
		ArrayList<Product> a = new ArrayList<Product>();
		ResultSet rs = null;
		rs = db.doSelect("select * from t_product where productName='"
				+ productName + "'");
		try {
			while (rs.next()) {
				Product p = new Product();
				p.setpId(rs.getInt("pId"));
				p.setProductName(rs.getString("productName"));
				p.setPrice(rs.getDouble("price"));
				p.setUnit(rs.getString("unit"));
				p.setDescription(rs.getString("description"));
				p.setPicture1(rs.getString("picture1"));
				p.setPicture2(rs.getString("picture2"));
				p.setPicture3(rs.getString("picture3"));
				p.setDeliveryPoint(rs.getString("deliveryPoint"));
				p.setOwnerId(rs.getInt("ownerId"));
				p.setUpdateTime(rs.getTimestamp("updateTime"));
				a.add(p);
			}
			db.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortByTimestamp(a);
	}

	@Override
	public Product selectById(int pId) {
		DBConn db = new DBConn();
		db.getConn();
		Product p = new Product();
		ResultSet rs = null;
		rs = db.doSelect("select * from t_product where pId=" + pId);
		try {
			if (rs.next()) {
				p.setpId(rs.getInt("pId"));
				p.setProductName(rs.getString("productName"));
				p.setPrice(rs.getDouble("price"));
				p.setUnit(rs.getString("unit"));
				p.setDescription(rs.getString("description"));
				p.setPicture1(rs.getString("picture1"));
				p.setPicture2(rs.getString("picture2"));
				p.setPicture3(rs.getString("picture3"));
				p.setDeliveryPoint(rs.getString("deliveryPoint"));
				p.setOwnerId(rs.getInt("ownerId"));
				p.setUpdateTime(rs.getTimestamp("updateTime"));
			}
			db.close(rs);
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Product> fuzzySelectByName(String productName) {
		DBConn db = new DBConn();
		db.getConn();
		ArrayList<Product> a = new ArrayList<Product>();
		ResultSet rs = null;
		rs = db.doSelect("select * from t_product where productName like '%"
				+ productName + "%' and productName!='" + productName + "'");
		try {
			while (rs.next()) {
				Product p = new Product();
				p.setpId(rs.getInt("pId"));
				p.setProductName(rs.getString("productName"));
				p.setPrice(rs.getDouble("price"));
				p.setUnit(rs.getString("unit"));
				p.setDescription(rs.getString("description"));
				p.setPicture1(rs.getString("picture1"));
				p.setPicture2(rs.getString("picture2"));
				p.setPicture3(rs.getString("picture3"));
				p.setDeliveryPoint(rs.getString("deliveryPoint"));
				p.setOwnerId(rs.getInt("ownerId"));
				p.setUpdateTime(rs.getTimestamp("updateTime"));
				a.add(p);
			}
			db.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortByTimestamp(a);
	}

	@Override
	public ArrayList<Product> selectByuId(int uId) {
		DBConn db = new DBConn();
		db.getConn();
		ArrayList<Product> a = new ArrayList<Product>();
		ResultSet rs = null;
		rs = db.doSelect("select * from t_product where ownerId=" + uId);
		try {
			while (rs.next()) {
				Product p = new Product();
				p.setpId(rs.getInt("pId"));
				p.setProductName(rs.getString("productName"));
				p.setPrice(rs.getDouble("price"));
				p.setUnit(rs.getString("unit"));
				p.setDescription(rs.getString("description"));
				p.setPicture1(rs.getString("picture1"));
				p.setPicture2(rs.getString("picture2"));
				p.setPicture3(rs.getString("picture3"));
				p.setDeliveryPoint(rs.getString("deliveryPoint"));
				p.setOwnerId(rs.getInt("ownerId"));
				p.setUpdateTime(rs.getTimestamp("updateTime"));
				a.add(p);
			}
			db.close(rs);
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private ArrayList<Product> sortByTimestamp(ArrayList<Product> a)
	{
		Comparator<Product> c=new Comparator<Product>(){
			@Override
			public int compare(Product o1, Product o2) {
				DateFormat sdf=new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
				String a2Str=sdf.format(o1.getUpdateTime());
				String b2Str=sdf.format(o2.getUpdateTime());
				String A[]=a2Str.split("/");
				String B[]=b2Str.split("/");
				if(Integer.parseInt(A[0])<Integer.parseInt(B[0]))
					return 1;
				else if(Integer.parseInt(A[1])<Integer.parseInt(B[1]))
					return 1;
				else if(Integer.parseInt(A[2])<Integer.parseInt(B[2]))
					return 1;
				else if(Integer.parseInt(A[3])<Integer.parseInt(B[3]))
					return 1;
				else if(Integer.parseInt(A[4])<Integer.parseInt(B[4]))
					return 1;
				else if(Integer.parseInt(A[5])<Integer.parseInt(B[5]))
					return 1;
				else
					return 0;
			}
		};
		Collections.sort(a, c);
		return a;
	}
	
	

}
