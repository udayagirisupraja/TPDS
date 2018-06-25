package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Admin;


public class AdminDAO {
	
	public int add(Admin admin){
		final String INSERT_QUERY = "insert into admin(userName,password) values(?,?)";
		PreparedStatement pst = null;
		Connection con = null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1,admin.getUserName());
			pst.setString(2, admin.getPassword());		
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public Admin getDetails(String userName, String pwd) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		Admin admin = new Admin();
		final String SELECT_QUERY = "select * from admin where userName = ? and password = ?";
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, userName);
			pst.setString(2, pwd);
			rst = pst.executeQuery();
			if (rst.next()) {
				admin.setUserName(rst.getString(1));
				admin.setPassword(rst.getString(2));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return(admin);
	}
	
	public Admin getDetails(String userName) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		Admin admin = new Admin();
		final String SELECT_QUERY = "select * from admin where userName = ?";
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, userName);
			rst = pst.executeQuery();
			if (rst.next()) {
				admin.setUserName(rst.getString(1));
				admin.setPassword(rst.getString(2));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return(admin);
	}
	
}

