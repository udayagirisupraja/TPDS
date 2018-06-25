package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.CitizenGoods;
import com.bvrit.tpds.dto.DealerGoods;

public class CitizenGoodsDAO {
	
	public int add(CitizenGoods citizenGoods){
		final String INSERT_QUERY = "insert into CitizenGoods(productName,productId,qty,price,aadharId,serialNo) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, citizenGoods.getProductName());
			pst.setString(2, citizenGoods.getProductId());
			pst.setString(3, citizenGoods.getQty());
			pst.setDouble(4, citizenGoods.getPrice());
			pst.setString(5, citizenGoods.getAadharId().getAadharId());
			pst.setInt(6, citizenGoods.getSerialNo().getSerialNo());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int update(CitizenGoods citizenGoods){
		final String INSERT_QUERY = "update CitizenGoods set productName = ?,productId = ?,qty = ?,price = ?,citizen_aadharId = ?,serialNo = ? where transactionId = ?";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, citizenGoods.getProductName());
			pst.setString(2, citizenGoods.getProductId());
			pst.setString(3, citizenGoods.getQty());
			pst.setDouble(4, citizenGoods.getPrice());
			pst.setString(5, citizenGoods.getAadharId().getAadharId());
			pst.setInt(6, citizenGoods.getSerialNo().getSerialNo());
			pst.setInt(7, citizenGoods.getTransactionId());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int delete(int transactionId) {
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
	    final String SELECT_QUERY = "delete from CitizenGoods where transactionId = ?";
	    try {
	    	con = DBConnection.getConnection();
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setInt(1, transactionId);
	    	status = pst.executeUpdate();
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();
	   }finally {
			DBConnection.close(pst,con);
		}
	    return status;
	 }
	
	public CitizenGoods getDetails(int transactionId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		CitizenGoods citizenGoods = new CitizenGoods();
		final String SELECT_QUERY = "select * from CitizenGoods where transactionId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, transactionId);
			rst = pst.executeQuery();
			
			if (rst.next()) {
				citizenGoods.setProductName(rst.getString(1));
				citizenGoods.setProductId(rst.getString(2));
				citizenGoods.setQty(rst.getString(3));
				citizenGoods.setPrice(rst.getDouble(4));
				CitizenDAO citizenDAO = new CitizenDAO();
				citizenGoods.setAadharId(citizenDAO.getDetails(rst.getString(5)));	
				DealerGoodsDAO dGoodsDao = new DealerGoodsDAO();
				DealerGoods dg = new DealerGoods();
				dg = dGoodsDao.getDetails(rst.getInt(6));
				citizenGoods.setSerialNo(dg);
				citizenGoods.setTransactionId(transactionId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return citizenGoods;
	}
	
	public List<CitizenGoods> getAll(String aadhar){
		List<CitizenGoods> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		final String SELECT_QUERY = "select * from CitizenGoods where aadharId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, aadhar);
			rst = pst.executeQuery();
			while(rst.next()){
				CitizenGoods citizenGoods = new CitizenGoods();
				citizenGoods.setProductName(rst.getString(1));
				citizenGoods.setProductId(rst.getString(2));
				citizenGoods.setQty(rst.getString(3));
				citizenGoods.setPrice(rst.getDouble(4));
				CitizenDAO citizenDAO = new CitizenDAO();
				citizenGoods.setAadharId(citizenDAO.getDetails(rst.getString(5)));	
				DealerGoodsDAO dGoodsDao = new DealerGoodsDAO();
				DealerGoods dg = new DealerGoods();
				dg = dGoodsDao.getDetails(rst.getInt(6));
				citizenGoods.setSerialNo(dg);
				citizenGoods.setTransactionId(rst.getInt(7));
				list.add(citizenGoods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
}
