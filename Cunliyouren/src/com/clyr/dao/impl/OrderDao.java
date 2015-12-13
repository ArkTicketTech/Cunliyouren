package com.clyr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.clyr.dao.IOrderDao;
import com.clyr.domain.Order;
import com.clyr.utils.DBConn;

public class OrderDao implements IOrderDao {

	@Override
	public void add(Order ord) {
		DBConn db = new DBConn();
		db.getConn();
		db.doInsert("insert into t_order values(null," + ord.getBuyerId() + ","
				+ ord.getSellerId() + "," + ord.getProductId() + ","
				+ ord.getPruductNumber() + ",null)");
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int oId) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Order> selectByBuyer(int bId) {
		DBConn db = new DBConn();
		db.getConn();
		ArrayList<Order> a = new ArrayList<Order>();
		ResultSet rs = null;
		rs = db.doSelect("select * from t_order where buyerId=" + bId);
		try {
			while (rs.next()) {
				Order o = new Order();
				o.setBuyerId(rs.getInt("buyerId"));
				o.setSellerId(rs.getInt("sellerId"));
				o.setoId(rs.getInt("oId"));
				o.setCreateTime(rs.getTimestamp("createTime"));
				o.setProductId(rs.getInt("productId"));
				o.setPruductNumber(rs.getInt("productNumber"));
				a.add(o);
			}
			db.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public ArrayList<Order> selectBySeller(int sId) {
		DBConn db = new DBConn();
		db.getConn();
		ArrayList<Order> a = new ArrayList<Order>();
		ResultSet rs = null;
		rs = db.doSelect("select * from t_order where sellerId=" + sId);
		try {
			while (rs.next()) {
				Order o = new Order();
				o.setBuyerId(rs.getInt("buyerId"));
				o.setSellerId(rs.getInt("sellerId"));
				o.setoId(rs.getInt("oId"));
				o.setCreateTime(rs.getTimestamp("createTime"));
				o.setProductId(rs.getInt("productId"));
				o.setPruductNumber(rs.getInt("productNumber"));
				a.add(o);
			}
			db.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

}
