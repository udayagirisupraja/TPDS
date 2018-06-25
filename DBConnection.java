package com.bvrit.tpds.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.http.Part;

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TPDS","root","11213");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Object ...args){
		try{
			
		for(Object k:args){
			if(k instanceof ResultSet)
				((ResultSet) k).close();
			else if(k instanceof Statement)
				((Statement) k).close();
			else if(k instanceof PreparedStatement)
				((Statement) k).close();
			else if(k instanceof Connection)
				((Connection) k).close();
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Date getUtilDate(String date) {
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
			utilDate=sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return utilDate;	
	}
	
	public static String getFileName(Part part) {		
		String content = part.getHeader("content-disposition");
		System.out.println("content-disposition :"+content);
		String fileName = content.substring(content.indexOf("filename") + 10, content.length() - 1);
	//	System.out.println("fileName"+fileName);
		return fileName;
	}
}