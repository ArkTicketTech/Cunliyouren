package com.clyr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clyr.dao.IAdminDao;
import com.clyr.domain.Admin;
import com.clyr.utils.DBConn;

public class AdminDao implements IAdminDao {

	@Override
	public Admin checkAdmin(String adminName, String password) {
		DBConn db = new DBConn();
		db.getConn();
		ResultSet rs = null;
		rs = db.doSelect("select * from t_admin where adminName='" + adminName
				+ "'");
		try {
			while (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					Admin a = new Admin();
					a.setAdminName(adminName);
					a.setPassword(password);
					db.close(rs);
					return a;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Admin admin) {
		DBConn db = new DBConn();
		db.getConn();
		db.doUpdate("update t_admin set password='" + admin.getPassword()
				+ "' where adminName='" + admin.getAdminName() + "';");
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
