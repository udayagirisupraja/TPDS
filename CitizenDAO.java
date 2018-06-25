package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.Citizen;

public class CitizenDAO {
	
	public int add(Citizen citizen){
		final String INSERT_QUERY = "insert into Citizen(aadharId,firstName,lastName,income,phoneNo,emailId,dOB,age,gender,noOfFamilyMembers,Occupation,photo,password,status,wardId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, citizen.getAadharId());
			pst.setString(2, citizen.getFirstName());
			pst.setString(3, citizen.getLastName());
			pst.setDouble(4, citizen.getIncome());
			pst.setString(5, citizen.getPhoneNo());
			pst.setString(6, citizen.getEmailId());
			pst.setDate(7, new java.sql.Date(citizen.getdOB().getTime()));
			pst.setInt(8, citizen.getAge());
			pst.setString(9, citizen.getGender());
			pst.setInt(10, citizen.getNoOfFamilyMembers());
			pst.setString(11, citizen.getOccupation());
			pst.setString(12, citizen.getPhoto());
			pst.setString(13,citizen.getPassword());
			pst.setString(14, citizen.getStatus());
			pst.setString(15, citizen.getWardId());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}

	public int update(Citizen citizen){
		final String INSERT_QUERY = "update Citizen set firstName = ?,lastName = ?,income = ?,phoneNo = ?,emailId = ?,dOB = ?,age = ?,gender = ?,noOfFamilyMembers = ?,Occupation = ?,photo = ?,password = ?,status = ? where aadharId = ? wardId = ? and password = ?";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
		    con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, citizen.getAadharId());
			pst.setString(2, citizen.getFirstName());
			pst.setString(3, citizen.getLastName());
			pst.setDouble(4, citizen.getIncome());
			pst.setString(5, citizen.getPhoneNo());
			pst.setString(6, citizen.getEmailId());
			pst.setDate(7, new java.sql.Date(citizen.getdOB().getTime()));
			pst.setInt(8, citizen.getAge());
			pst.setString(9, citizen.getGender());
			pst.setInt(10, citizen.getNoOfFamilyMembers());
			pst.setString(11, citizen.getOccupation());
			pst.setString(12, citizen.getPhoto());
			pst.setString(13, citizen.getPassword());
			pst.setString(14, citizen.getStatus());
			pst.setString(15, citizen.getWardId());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con);
		}
		return status;
	}
	
	public int delete(int aadharId) {
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
	    final String SELECT_QUERY = "delete from Citizen where aadharId = ? ";
	    try {
	    	con = DBConnection.getConnection();
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setInt(1, aadharId);
	    	status = pst.executeUpdate();
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();
	   }finally {
			DBConnection.close(pst,con);
		}
	    return status;
	 }
	
	public Citizen isExists(String aadharId,String password) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		Citizen citizen = new Citizen();
		final String SELECT_QUERY = "select * from Citizen where aadharId = ? and password = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, aadharId);
			pst.setString(2,password);
			rst = pst.executeQuery();
			if (rst.next()) {
				citizen.setAadharId(rst.getString(1));
				citizen.setFirstName(rst.getString(2));
				citizen.setLastName(rst.getString(3));
			    citizen.setIncome(rst.getDouble(4));
				citizen.setPhoneNo(rst.getString(5));
				citizen.setEmailId(rst.getString(6));				
				citizen.setdOB(rst.getDate(7));
				citizen.setAge(rst.getInt(8));
				citizen.setGender(rst.getString(9));
				citizen.setNoOfFamilyMembers(rst.getInt(10));
				citizen.setOccupation(rst.getString(11));
				citizen.setPhoto(rst.getString(12));
				citizen.setPassword(rst.getString(13));
				citizen.setStatus(rst.getString(14));
				citizen.setWardId(rst.getString(15));
				
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBConnection.close(pst,con,rst);
	}
	return citizen;
	}
	
	public Citizen getDetails(String aadharId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		Citizen citizen = new Citizen();
		final String SELECT_QUERY = "select * from Citizen where aadharId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, aadharId);
			rst = pst.executeQuery();
			if (rst.next()) {
				citizen.setAadharId(rst.getString(1));
				citizen.setFirstName(rst.getString(2));
				citizen.setLastName(rst.getString(3));
			    citizen.setIncome(rst.getDouble(4));
				citizen.setPhoneNo(rst.getString(5));
				citizen.setEmailId(rst.getString(6));
				citizen.setdOB(rst.getDate(7));
				citizen.setAge(rst.getInt(8));
				citizen.setGender(rst.getString(9));
				citizen.setNoOfFamilyMembers(rst.getInt(10));
				citizen.setOccupation(rst.getString(11));
				citizen.setPhoto(rst.getString(12));
				citizen.setPassword(rst.getString(13));
				citizen.setStatus(rst.getString(14));
				citizen.setWardId(rst.getString(15));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBConnection.close(pst,con,rst);
	}
	return citizen;
	}
	
	
	public List<Citizen> getAll(){
		List<Citizen> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		final String SELECT_QUERY = "select * from Citizen";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				Citizen citizen = new Citizen();

				citizen.setAadharId(rst.getString(1));
				citizen.setFirstName(rst.getString(2));
				citizen.setLastName(rst.getString(3));
				citizen.setIncome(rst.getDouble(4));
				citizen.setPhoneNo(rst.getString(5));
				citizen.setEmailId(rst.getString(6));
				citizen.setdOB(rst.getDate(7));
				citizen.setAge(rst.getInt(8));
				citizen.setGender(rst.getString(9));
				citizen.setNoOfFamilyMembers(rst.getInt(10));
				citizen.setOccupation(rst.getString(11));
				citizen.setPhoto(rst.getString(12));
				citizen.setPassword(rst.getString(13));
				citizen.setStatus(rst.getString(14));
				citizen.setWardId(rst.getString(15));
				list.add(citizen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
	
	public List<Citizen> getAll(String wardId){
		List<Citizen> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con=null;
		final String SELECT_QUERY = "select * from Citizen where wardId = ?";
		System.out.println("\n\n inside citizen dao" +  "\n" );

		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, wardId);
			rst = pst.executeQuery();
			while(rst.next()){
				Citizen citizen = new Citizen();

				citizen.setAadharId(rst.getString(1));
				citizen.setFirstName(rst.getString(2));
				citizen.setLastName(rst.getString(3));
				citizen.setIncome(rst.getDouble(4));
				citizen.setPhoneNo(rst.getString(5));
				citizen.setEmailId(rst.getString(6));
				citizen.setdOB(rst.getDate(7));
				citizen.setAge(rst.getInt(8));
				citizen.setGender(rst.getString(9));
				citizen.setNoOfFamilyMembers(rst.getInt(10));
				citizen.setOccupation(rst.getString(11));
				citizen.setPhoto(rst.getString(12));
				citizen.setPassword(rst.getString(13));
				citizen.setStatus(rst.getString(14));
				citizen.setWardId(rst.getString(15));
				
				System.out.println("\n\n inside citizen dao" +  citizen + "\n" );

				list.add(citizen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
}
