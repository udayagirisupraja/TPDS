package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Dealer;
import com.bvrit.tpds.dto.DealerGoods;

public class DealerGoodsDAO {
	
	public int add(DealerGoods dealerGoods){
		final String INSERT_QUERY = "insert into DealerGoods(productName,productId,qty,price,priceFor,Dealer_aadharId) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, dealerGoods.getProductName());
			pst.setString(2, dealerGoods.getProductId());
			pst.setString(3, dealerGoods.getQty());
			pst.setDouble(4, dealerGoods.getPrice());
			pst.setDouble(5, dealerGoods.getPriceFor());
			pst.setString(6, dealerGoods.getAadharId().getAadharId());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	public int update(DealerGoods dealerGoods){
		final String INSERT_QUERY = "update DealerGoods set productName = ?,productId = ?,qty = ?,price = ?,Dealer_aadharId = ?,priceFor = ? where serialNo = ?";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, dealerGoods.getProductName());
			pst.setString(2, dealerGoods.getProductId());
			pst.setString(3, dealerGoods.getQty());
			pst.setDouble(4, dealerGoods.getPrice());
			pst.setDouble(5, dealerGoods.getPriceFor());
			pst.setString(6, dealerGoods.getAadharId().getAadharId());
			pst.setInt(7, dealerGoods.getSerialNo());
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
	    final String SELECT_QUERY = "delete from DealerGoods where serialNo = ?";
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
	public DealerGoods getDetails(int serialNo) {
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		DealerGoods dealerGoods = new DealerGoods();
		final String SELECT_QUERY = "select * from DealerGoods where serialNo = ?";
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, serialNo);
			rst = pst.executeQuery();
			if (rst.next()) {
				dealerGoods.setProductName(rst.getString(1));
				dealerGoods.setProductId(rst.getString(2));
				dealerGoods.setQty(rst.getString(3));
				dealerGoods.setPrice(rst.getDouble(4));
				DealerDAO  dealerDAO = new DealerDAO();
				Dealer dealer = new Dealer();
				dealer = dealerDAO.getDetails(rst.getString(5));
				dealerGoods.setAadharId(dealer);
				dealerGoods.setPriceFor(rst.getDouble(6));
				dealerGoods.setSerialNo(rst.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return dealerGoods;
	}
	
	public DealerGoods getDetails(String  dealer_aadharId) {
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		DealerGoods dealerGoods = new DealerGoods();
		final String SELECT_QUERY = "select * from DealerGoods where Dealer_aadharId = ?";
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, dealer_aadharId);
			rst = pst.executeQuery();
			if (rst.next()) {
				dealerGoods.setProductName(rst.getString(1));
				dealerGoods.setProductId(rst.getString(2));
				dealerGoods.setQty(rst.getString(3));
				dealerGoods.setPrice(rst.getDouble(4));
				DealerDAO  dealerDAO = new DealerDAO();
				Dealer dealer = new Dealer();
				dealer = dealerDAO.getDealer(rst.getString(5));
				dealerGoods.setAadharId(dealer);
				dealerGoods.setPriceFor(rst.getDouble(6));
				dealerGoods.setSerialNo(rst.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return dealerGoods;
	} 
	
	
	public List<DealerGoods> getAll(String aadharId){
		List<DealerGoods> list=new ArrayList<>();
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from DealerGoods where Dealer_aadharId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, aadharId);
			rst = pst.executeQuery();
			while(rst.next()){
				DealerGoods dealerGoods = new DealerGoods();
				dealerGoods.setProductName(rst.getString(1));
				dealerGoods.setProductId(rst.getString(2));
				dealerGoods.setQty(rst.getString(3));
				dealerGoods.setPrice(rst.getDouble(4));
				DealerDAO  dealerDAO = new DealerDAO();
				Dealer dealer = new Dealer();
				dealer = dealerDAO.getDetails(rst.getString(5));
				dealerGoods.setAadharId(dealer);
				dealerGoods.setPriceFor(rst.getDouble(6));	
				dealerGoods.setSerialNo(rst.getInt(7));
				list.add(dealerGoods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
}

