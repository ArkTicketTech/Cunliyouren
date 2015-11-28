package com.clyr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.clyr.dao.IProductDao;

import com.clyr.domain.Product;
import com.clyr.utils.DBConn;

public class ProductDao implements IProductDao{

	@Override
	public void add(Product pro) {
		DBConn db=new DBConn();  
		db.getConn();
		db.doInsert("insert into product values('"+pro.getProductName()+"',"+pro.getPrice()+",'"
		+pro.getUnit()+"','"+pro.getDescription()+"','"+pro.getPicture1()+"','"+pro.getPicture2()
		+"','"+pro.getPicture3()+"','"+pro.getDeliveryPoint()+"',"+pro.getOwnerId()+")");
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
		DBConn db=new DBConn();  
		db.getConn();
		db.doDelete("delete from product where pId="+pId);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Product> selectByName(String productName) {
		DBConn db=new DBConn();  
		db.getConn();  
		ArrayList<Product> a=new ArrayList<Product>();
		ResultSet rs=null;
		rs=db.doSelect("select * from product where productName="+productName);  
		try {  
			while(rs.next()){  
				Product p=new Product();
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
				p.setUpdateTime(rs.getString("updateTime"));
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

	@Override
	public Product selectById(int pId) {
		DBConn db=new DBConn();  
		db.getConn();  
		Product p=new Product();
		ResultSet rs=null;
		rs=db.doSelect("select * from product where pId="+pId);  
		try {  
			if(rs.next()){  
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
				p.setUpdateTime(rs.getString("updateTime"));
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
		DBConn db=new DBConn();  
		db.getConn();  
		ArrayList<Product> a=new ArrayList<Product>();
		ResultSet rs=null;
		rs=db.doSelect("select * from product where productName like %"+productName+"% and productName!="+productName);  
		try {  
			while(rs.next()){  
				Product p=new Product();
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
				p.setUpdateTime(rs.getString("updateTime"));
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


}
