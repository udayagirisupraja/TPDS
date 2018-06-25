package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Ward;

public class WardDAO {
	
	public int add(Ward wd){
		final String INSERT_QUERY = "insert into ward(name,wardId,districtId) values(?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, wd.getname());
			pst.setString(2, wd.getwardId());
			pst.setString(3,wd.getDistrictId().getDistrictId());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int update(Ward wd){
		final String INSERT_QUERY = "update ward set name = ?, districtId = ? where wardId = ?";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, wd.getname());
			pst.setString(2, wd.getwardId());
			pst.setString(3,wd.getDistrictId().getDistrictId());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int delete(String wardId) {
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
	    final String SELECT_QUERY = "delete from Ward where wardId = ?";
	    try {
	    	con = DBConnection.getConnection();
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, wardId);
	    	status = pst.executeUpdate();
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();
	    } finally {
			DBConnection.close(pst,con);
		}	
	    return status;
	 }
	
	public Ward getDetails(String wardId) {		
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		Ward ward = new Ward();
		final String SELECT_QUERY = "select * from ward where wardId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, wardId);
			rst = pst.executeQuery();
			if (rst.next()) {
				ward.setname(rst.getString(1));
				ward.setwardId(rst.getString(2));
				DistrctDAO districtDao = new DistrctDAO();
				ward.setDistrictId(districtDao.getDetails(rst.getString(3)));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return(ward);
	}
	
	public List<Ward> getAll(String districtId){
		List<Ward> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from Ward where districtId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, districtId);
			rst = pst.executeQuery();
			while(rst.next()){
				Ward ward = new Ward();
				ward.setname(rst.getString(1));
				ward.setwardId(rst.getString(2));
				DistrctDAO districtDao = new DistrctDAO();
				ward.setDistrictId(districtDao.getDetails(rst.getString(3)));	
				list.add(ward);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
	
	public List<Ward> getAll(){
		List<Ward> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from Ward order by districtId;";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				Ward ward = new Ward();
				ward.setname(rst.getString(1));
				ward.setwardId(rst.getString(2));
				DistrctDAO districtDao = new DistrctDAO();
				ward.setDistrictId(districtDao.getDetails(rst.getString(3)));	
				list.add(ward);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
}
