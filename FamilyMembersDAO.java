package com.bvrit.tpds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bvrit.tpds.dbutility.DBConnection;
import com.bvrit.tpds.dto.FamilyMembers;

public class FamilyMembersDAO {
	
	public int add(FamilyMembers familymember){
		final String INSERT_QUERY = "insert into familyMembers(aadharId,firstName,lastName,dOB,age,gender,Occupation,Citizen_aadharId) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, familymember.getAadharId());
			pst.setString(2, familymember.getFirstName());
			pst.setString(3, familymember.getLastName());
			pst.setDate(4, new java.sql.Date(familymember.getdOB().getTime()));
			pst.setInt(5, familymember.getAge());
			pst.setString(6, familymember.getGender());
			pst.setString(7, familymember.getOccupation());
			pst.setString(8, familymember.getCitizen_aadharId().getAadharId());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con);
		}
		return status;
	}

	public int update(FamilyMembers familyMembers){
		final String INSERT_QUERY = "update FamilyMembers set firstName = ?,lastName = ?,dOB = ?,age = ?,gender = ?,occupation = ?,Citizen_aadharId = ? where aadharId = ?";
		PreparedStatement pst = null;
		Connection con=null;
		int status = 0;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, familyMembers.getFirstName());
			pst.setString(2, familyMembers.getLastName());
			pst.setDate(3, new java.sql.Date(familyMembers.getdOB().getTime()));
			pst.setDouble(4, familyMembers.getAge());
			pst.setString(5, familyMembers.getGender());
			pst.setString(6, familyMembers.getOccupation());
			pst.setString(7, familyMembers.getCitizen_aadharId().getAadharId());
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
	    final String SELECT_QUERY = "delete from familyMembers where aadharId = ?";
	    try {
	    	con = DBConnection.getConnection();
	    	pst = con.prepareStatement(SELECT_QUERY);
	    	pst.setString(1, aadharId);
	    	status = pst.executeUpdate();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    } finally {
			DBConnection.close(pst,con);
		}	
	    return status;
	}
	
	public FamilyMembers getDetails(String aadharId) {
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		FamilyMembers familyMembers = new FamilyMembers();
		final String SELECT_QUERY = "select * from familyMembers where aadharId = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, aadharId);
			rst = pst.executeQuery();
			if (rst.next()){
				familyMembers.setAadharId(rst.getString(1));
				familyMembers.setFirstName(rst.getString(2));
				familyMembers.setLastName(rst.getString(3));
				familyMembers.setAge(rst.getInt(4));
				familyMembers.setdOB(DBConnection.getUtilDate(rst.getString(5)));
				familyMembers.setGender(rst.getString(6));
			    familyMembers.setOccupation(rst.getString(7));
			    CitizenDAO citizentDao = new CitizenDAO();
				familyMembers.setCitizen_aadharId(citizentDao.getDetails(rst.getString(8)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return familyMembers;
	}
	
	public List<FamilyMembers> getAll(String aadharId){
		List<FamilyMembers> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		Connection con=null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select * from familyMembers where Citizen_aadharId = ?";
		try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, aadharId);
			rst = pst.executeQuery();
			while(rst.next()){
				FamilyMembers familyMembers = new FamilyMembers();
				familyMembers.setAadharId(rst.getString(1));
				familyMembers.setFirstName(rst.getString(2));
				familyMembers.setLastName(rst.getString(3));
				familyMembers.setAge(rst.getInt(4));
				familyMembers.setdOB(DBConnection.getUtilDate(rst.getString(5)));
				familyMembers.setGender(rst.getString(6));
			    familyMembers.setOccupation(rst.getString(7));
			    CitizenDAO citizentDao = new CitizenDAO();
				familyMembers.setCitizen_aadharId(citizentDao.getDetails(rst.getString(8)));
				list.add(familyMembers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pst,con,rst);
		}
		return list;
	}
}



