package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.accenture.lkm.utility.DBUtility;

public class LoginDetails {
	
	public static boolean validate1(String name, String pass) {
		boolean status = false;
		Connection connection=null;
		try {
			System.out.println("1");
			String retrievedata = "select * from login where name=? and pass=?";
			  Class.forName("com.mysql.jdbc.Driver");
			  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","root");
			PreparedStatement psp = connection.prepareStatement(retrievedata);
			psp.setString(1,name);
			psp.setString(2,pass);
			System.out.println(name);
			ResultSet rsp = psp.executeQuery();
			status  = rsp.next();
			
		 }catch (ClassNotFoundException | SQLException  e){
			   e.printStackTrace();
		 } 
		 finally {
			 
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return status;
	}
	

}


