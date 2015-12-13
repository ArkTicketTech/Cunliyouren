package com.clyr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clyr.domain.AccessToken;
import com.clyr.utils.DBConn;

public class AccessTokenDao {
	public void add(String token) {
		DBConn db = new DBConn();
		db.getConn();
		db.doInsert("insert into t_access values(1,'"+token+"',null)");
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(String token) {
		DBConn db = new DBConn();
		db.getConn();
		db.doUpdate("update t_access set accessToken='"
					+ token + "' where aId=1");
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public AccessToken select() {
		DBConn db = new DBConn();
		db.getConn();
		AccessToken a=new AccessToken();
		ResultSet rs = null;
		boolean flag=true;
		rs = db.doSelect("select * from t_access where aId=1");
		try {
			if (rs.next()) {
				a.setAccessToken(rs.getString("accessToken"));
				a.setCreateTime(rs.getTimestamp("createTime"));
				flag=false;
			}
			db.close();
			if(flag)
				return null;
			else
				return a;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
