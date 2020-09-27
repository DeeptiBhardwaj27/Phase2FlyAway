package com.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDetails;

/**
 * Servlet implementation class LoginSer
 */
@WebServlet("/LoginSer")
public class NewServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter op1 = response.getWriter();
		String name1 = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		
		
		//LoginDetails.validate1(name1, pass);
		if(LoginDetails.validate1(name1,pass))
		{
			System.out.println("ALL WORKING");
			
			ResultSet rsp = null;		
			Connection connection=null;
			
			try {
				String retrievedata ="select * from planes";
				  Class.forName("com.mysql.jdbc.Driver");
				  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","root");
				PreparedStatement psp = connection.prepareStatement(retrievedata);
				
				rsp = psp.executeQuery();
				op1.println("<form action=Search.html method=post>");
				 op1.println("<table border=1 width=100%>");
				 op1.println("<tr><th>Flights Number</th><th>Source</th><th>Destination</th><th>Price</th><tr>"); 
				
			
				while(rsp.next()) {
					int id = rsp.getInt("id");
					int price = rsp.getInt("price");
					String src = rsp.getString("source");
					String dest = rsp.getString("destination");
					op1.println("<tr><td>" + id + "</td><td>" +src+ "</td><td>" + dest + "</td><td>" + price + "</td></tr>");
				
				}
				op1.println("</table>"); 
				
	            
	            
	            op1.println("<center><input type=submit name=del value=Continue ></center>");
	            
	            op1.println("</form>");
	            op1.println("</html></body>"); 
					
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
		}
		else
		{
			op1.write("Login Unsuccesful");
		RequestDispatcher df = request.getRequestDispatcher("LoginNew1.html");
		df.include(request, response);
		}
		
	}

}
