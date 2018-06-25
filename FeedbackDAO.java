package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Feedback;

public class FeedbackDAO {
	
	public int add(Feedback feedback){
		final String INSERT_QUERY = "insert into Feedback(citizenFeedback,status,transcationId) values(?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, feedback.getCitizenFeedback());
			pst.setString(2, feedback.getStatus());	
			pst.setInt(3,feedback.getTransactionId().getTransactionId().getTransactionId());
			status = pst.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	public int update(Feedback fb){
		final String INSERT_QUERY = "update Feedback set citizenFeedback = ?, status = ? where transactionId = ?";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, fb.getCitizenFeedback());
			pst.setString(2, fb.getStatus());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int delete(String transactionId) {
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
	    final String SELECT_QUERY = "delete from Feedback where transactionId = ?";
	    try {
	    	con = DBConnection.getConnection();
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, transactionId);
	    	status = pst.executeUpdate();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    } finally {
			DBConnection.close(pst,con);
		}
	    return status;
	 }
	
	public Feedback getDetails(int transactionId) {
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		Feedback feedback = new Feedback();
		final String SELECT_QUERY = "select * from Feedback where transactionId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, transactionId);
			rst = pst.executeQuery();
			if (rst.next()) {
				feedback.setCitizenFeedback(rst.getString(1));
				feedback.setStatus(rst.getString(2));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return(feedback);
	}
	
	public List<Feedback> getAll(){
		List<Feedback> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from Feedback";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				Feedback feedback = new Feedback();
				
				feedback.setCitizenFeedback(rst.getString(1));
				feedback.setStatus(rst.getString(2));	
				list.add(feedback);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
}

