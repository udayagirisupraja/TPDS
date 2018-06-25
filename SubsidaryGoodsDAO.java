package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Admin;
import com.bvrit.tpds.dto.SubsidaryGoods;

public class SubsidaryGoodsDAO {
	
	public int add(SubsidaryGoods sbgoods){
		final String INSERT_QUERY = "insert into subsidaryGoods(Name,qty,userName,price,priceFor) values(?,?,?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, sbgoods.getName());
			pst.setString(2, sbgoods.getQty());
			pst.setString(3, sbgoods.getUserName().getUserName());
			pst.setDouble(4, sbgoods.getPrice());
			pst.setDouble(5, sbgoods.getPriceFor());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int update(SubsidaryGoods sbgoods){
		final String INSERT_QUERY = "update subsidaryGoods set Name = ?,qty = ?,userName = ?,price = ?,priceFor = ? where serialNo = ?";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, sbgoods.getName());
			pst.setString(2, sbgoods.getQty());
			pst.setString(3, sbgoods.getUserName().getUserName());
			pst.setDouble(4, sbgoods.getPrice());
			pst.setInt(5,sbgoods.getSerialNo());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int delete(int serialNo) {
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
	    final String SELECT_QUERY = "delete from subsidaryGoods where serialNo = ?";
	    try {
	    	con = DBConnection.getConnection();
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setInt(1, serialNo);
	    	status = pst.executeUpdate();
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();
	   } finally {
			DBConnection.close(pst,con);
		}	
	    return status;
	 }
	
	public SubsidaryGoods getDetails(int serialNo) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		SubsidaryGoods sbGoods = new SubsidaryGoods();
		final String SELECT_QUERY = "select * from subsidaryGoods where serialNo = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, serialNo);
			rst = pst.executeQuery();
			
			if (rst.next()) {
				sbGoods.setName(rst.getString(1));
				sbGoods.setSerialNo(rst.getInt(2));
				sbGoods.setQty(rst.getString(3));
				Admin admin = new Admin();
				admin.setUserName(rst.getString(4));
				sbGoods.setUserName(admin);
				sbGoods.setPrice(rst.getDouble(5));
				sbGoods.setPriceFor(rst.getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return sbGoods;
	}
	
	public List<SubsidaryGoods> getAll(){
		List<SubsidaryGoods> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from SubsidaryGoods";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				SubsidaryGoods sbGoods = new SubsidaryGoods();
				sbGoods.setName(rst.getString(1));
				sbGoods.setSerialNo(rst.getInt(2));
				sbGoods.setQty(rst.getString(3));
				Admin admin = new Admin();
				admin.setUserName(rst.getString(4));
				sbGoods.setUserName(admin);
				sbGoods.setPrice(rst.getDouble(5));
				sbGoods.setPriceFor(rst.getDouble(6));
	
				list.add(sbGoods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
	

}
