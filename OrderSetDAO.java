package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Orderset;

public class OrderSetDAO {
	
	public int add(Orderset orderset){
		final String INSERT_QUERY = "insert into Orderset(amount,TransactionId,TransactionDate,issueDate,year,status) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setDouble(1, orderset.getAmount());
			pst.setInt(2, orderset.getTransactionId().getTransactionId());
			pst.setString(2, orderset.getTransactiondate());
			pst.setString(3, orderset.getIssueDate());
			pst.setLong(4, orderset.getYear());
			pst.setString(5, orderset.getStatus());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	public int update(Orderset orderset){
		final String INSERT_QUERY = "update Orderset set amount = ?,transacStiondate = ?,issueDate = ?,year = ?,status = ? where transactionId = ?";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setDouble(1, orderset.getAmount());
			pst.setString(2, orderset.getTransactiondate());
			pst.setString(3, orderset.getIssueDate());
			pst.setInt(4, orderset.getYear());
			pst.setString(3, orderset.getStatus());
			pst.setLong(5, orderset.getTransactionId().getTransactionId());
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
	    final String SELECT_QUERY = "delete from Orderset where transactionId = ?";
	    try {
	    	con = DBConnection.getConnection();
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setInt(1, transactionId);
	    	status = pst.executeUpdate();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    } finally {
			DBConnection.close(pst,con);
		}
	    return status;
	}
	
	public Orderset getDetails(int transactionId) {
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		Orderset orderset = new Orderset();
		final String SELECT_QUERY = "select * from Orderset where transactionId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, transactionId);
			rst = pst.executeQuery();
			if (rst.next()) {
				orderset.setAmount(rst.getDouble(1));
				orderset.setTransactiondate(rst.getString(2));
				orderset.setIssueDate(rst.getString(3));
				orderset.setYear(rst.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return orderset;
	}
	
	public List<Orderset> getAll(){
		List<Orderset> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from Orderset";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				Orderset orderset = new Orderset();
				orderset.setAmount(rst.getDouble(1));
				orderset.setTransactiondate(rst.getString(2));
				orderset.setIssueDate(rst.getString(3));
				orderset.setYear(rst.getInt(4));
				
				list.add(orderset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
}

