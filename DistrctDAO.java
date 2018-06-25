package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Admin;
import com.bvrit.tpds.dto.District;

public class DistrctDAO {
	public int add(com.bvrit.tpds.dto.District district){
		final String INSERT_QUERY = "insert into District(name,districtId,userName) values(?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, district.getName());
			pst.setString(2, district.getDistrictId());
			pst.setString(3, district.getUserName().getUserName());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	public int update(District district){
		final String INSERT_QUERY = "update District set name = ?, username = ? where districtId = ?";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, district.getName());
			pst.setString(2,district.getUserName().getUserName());
			pst.setString(3, district.getDistrictId());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int delete(String districtId) {
		PreparedStatement pst = null;
        Connection con=null;
		int status = 0;
	    final String SELECT_QUERY = "delete from Ward where districtId = ?";
	    try {
	    	con = DBConnection.getConnection();
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, districtId);
	    	status = pst.executeUpdate();
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();
	   } finally {
			DBConnection.close(pst,con);
		}	
	    return status;
	 }
	
	public District getDetails(String districtId) {
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		District district = new District();
		final String SELECT_QUERY = "select * from District where districtId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, districtId);
			rst = pst.executeQuery();
			if (rst.next()) {
				district.setName(rst.getString(1));
				district.setDistrictId(rst.getString(2));
				Admin admin = new Admin();
				admin.setUserName(rst.getString(3));
				district.setUserName(admin);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return(district);
	}
	
	public List<District> getAll(){
		List<District> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from District";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()) {
				District district = new District();
				district.setName(rst.getString(1));
				district.setDistrictId(rst.getString(2));	
				Admin admin = new Admin();
				admin.setUserName(rst.getString(3));
				district.setUserName(admin);
				list.add(district);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
}
