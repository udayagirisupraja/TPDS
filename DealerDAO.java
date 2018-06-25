package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Dealer;

public class DealerDAO {
	
	public int add(Dealer dealer){
		final String INSERT_QUERY = "insert into Dealer(aadharId,firstName,lastName,phoneNo,emailId,gender,dOB,age,wardId,photo,password,status) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, dealer.getAadharId());
			pst.setString(2, dealer.getFirstName());
			pst.setString(3, dealer.getLastName());		
			pst.setString(4, dealer.getPhoneNo());
			pst.setString(5, dealer.getEmailId());
			pst.setString(6, dealer.getGender());
			pst.setDate(7, new java.sql.Date(dealer.getdOB().getTime()));
			pst.setInt(8, dealer.getAge());			
			pst.setString(9, dealer.getWardId().getwardId());			
			pst.setString(10, dealer.getPhoto());
			pst.setString(11, dealer.getPassword());
			pst.setString(12, dealer.getStatus());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	public int update(Dealer dealer){
		final String INSERT_QUERY = "update Dealer set firstName = ?,lastName = ?,phoneNo = ?,emailId = ?,gender = ?,dOB = ?,age = ?,wardId = ?,photo = ?,status = ? where aadharId = ? and password = ?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, dealer.getAadharId());
			pst.setString(2, dealer.getFirstName());
			pst.setString(3, dealer.getLastName());		
			pst.setString(4, dealer.getPhoneNo());
			pst.setString(5, dealer.getEmailId());
			pst.setString(6, dealer.getGender());
			pst.setDate(7, new java.sql.Date(dealer.getdOB().getTime()));
			pst.setInt(8, dealer.getAge());
			pst.setString(9, dealer.getWardId().getwardId());
			pst.setString(10, dealer.getPhoto());
			pst.setString(11, dealer.getPassword());
			pst.setString(12, dealer.getStatus());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int delete(String aadharId) {
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
	    final String SELECT_QUERY = "delete from Dealer where aadharId = ?";
	    try {
	        con = DBConnection.getConnection();
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, aadharId);
	    	status = pst.executeUpdate();
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();
	   } finally {
			DBConnection.close(pst,con);
		}
	    return status;
	 }
	
	public Dealer isExists(String aadharId,String password) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		Dealer dealer = new Dealer();
		final String SELECT_QUERY = "select * from Dealer where aadharId = ? and password = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, aadharId);
			pst.setString(2, password);
			rst = pst.executeQuery();
			if (rst.next()) {
				dealer.setAadharId(rst.getString(1));
				dealer.setFirstName(rst.getString(2));
				dealer.setLastName(rst.getString(3));
				dealer.setPhoneNo(rst.getString(4));
				dealer.setEmailId(rst.getString(5));
				dealer.setGender(rst.getString(6));
				dealer.setdOB(rst.getDate(7));
				dealer.setAge(rst.getInt(8));
				WardDAO wardDao = new WardDAO();
				dealer.setWardId(wardDao.getDetails(rst.getString(9)));
				dealer.setPhoto(rst.getString(10));
				dealer.setPassword(rst.getString(11));
				dealer.setStatus(rst.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return dealer;
	}
	
	public Dealer getDetails(String wardId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		Dealer dealer = new Dealer();
		final String SELECT_QUERY = "select * from Dealer where wardId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, wardId);
			rst = pst.executeQuery();
			if (rst.next()) {
				dealer.setAadharId(rst.getString(1));
				dealer.setFirstName(rst.getString(2));
				dealer.setLastName(rst.getString(3));
				dealer.setPhoneNo(rst.getString(4));
				dealer.setEmailId(rst.getString(5));
				dealer.setGender(rst.getString(6));
				dealer.setdOB(rst.getDate(7));
				dealer.setAge(rst.getInt(8));
				WardDAO wardDao = new WardDAO();
				dealer.setWardId(wardDao.getDetails(rst.getString(9)));
				dealer.setPhoto(rst.getString(10));
				dealer.setPassword(rst.getString(11));
				dealer.setStatus(rst.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return dealer;
	}
	
	public Dealer getDealer(String aadharId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		Dealer dealer = new Dealer();
		final String SELECT_QUERY = "select * from Dealer where aadharId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, aadharId);
			rst = pst.executeQuery();
			if (rst.next()) {
				dealer.setAadharId(rst.getString(1));
				dealer.setFirstName(rst.getString(2));
				dealer.setLastName(rst.getString(3));
				dealer.setPhoneNo(rst.getString(4));
				dealer.setEmailId(rst.getString(5));
				dealer.setGender(rst.getString(6));
				dealer.setdOB(rst.getDate(7));
				dealer.setAge(rst.getInt(8));
				WardDAO wardDao = new WardDAO();
				dealer.setWardId(wardDao.getDetails(rst.getString(9)));
				dealer.setPhoto(rst.getString(10));
				dealer.setPassword(rst.getString(11));
				dealer.setStatus(rst.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return dealer;
	}
	
	public List<Dealer> getAll(){
		List<Dealer> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		final String SELECT_QUERY = "select * from Dealer";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				Dealer dealer = new Dealer();	
				dealer.setAadharId(rst.getString(1));
				dealer.setFirstName(rst.getString(2));
				dealer.setLastName(rst.getString(3));
				dealer.setPhoneNo(rst.getString(4));
				dealer.setEmailId(rst.getString(5));
				dealer.setGender(rst.getString(6));
				dealer.setdOB(rst.getDate(7));
				dealer.setAge(rst.getInt(8));
				WardDAO wardDao = new WardDAO();
				dealer.setWardId(wardDao.getDetails(rst.getString(9)));
				dealer.setPhoto(rst.getString(10));
				dealer.setPassword(rst.getString(11));
				dealer.setStatus(rst.getString(12));
				list.add(dealer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
}

