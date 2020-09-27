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

/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Select() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter op1 = response.getWriter();
		String update1 = request.getParameter("update");
		String all= request.getParameter("update");
		String sc2 = request.getParameter("update");
		System.out.println(all);
		if(update1.equals("UPDATE PASSWORD")) {
			
			RequestDispatcher df = request.getRequestDispatcher("newpass.html");
			df.forward(request, response);
		}
		else if(all.equals("ALL FLIGHT DETAILS")){
			ResultSet rsp = null;		
			Connection connection=null;
			
			try {
				String retrievedata ="select * from planes";
				  Class.forName("com.mysql.jdbc.Driver");
				  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","root");
				PreparedStatement psp = connection.prepareStatement(retrievedata);
				
				rsp = psp.executeQuery();
				op1.println("<form action=Register.html method=post>");
				 op1.println("<table border=1 width=100%>");
				 op1.println("<tr><th>flights Number</th><th>Source</th><th>Destination</th><th>Price</th><tr>"); 
				
			
				while(rsp.next()) {
					int id = rsp.getInt("id");
					int price = rsp.getInt("price");
					String src = rsp.getString("source");
					String dest = rsp.getString("destination");
					op1.println("<tr><td>" + id + "</td><td>" +src+ "</td><td>" + dest + "</td><td>" + price + "</td></tr>");
				
				}
				op1.println("</table>");  
	            op1.println("</html></body>"); 
	            
	            op1.println();
	            
	            op1.println("</form>");
					
					
				
				
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
		else if(sc2.equals("FLIGHT SCHEDULE ")) {
			ResultSet rsp = null;		
			Connection connection=null;
			
			try {
				String retrievedata ="select id,source,destination from planes";
				  Class.forName("com.mysql.jdbc.Driver");
				  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","root");
				PreparedStatement psp = connection.prepareStatement(retrievedata);
				
				rsp = psp.executeQuery();
				op1.println("<form action=Register.html method=post>");
				 op1.println("<table border=1 width=100%>");
				 op1.println("<tr><th>flights Number</th><th>Source</th><th>Destination</th><tr>"); 
				
			
				while(rsp.next()) {
					int id = rsp.getInt("id");
					
					String src = rsp.getString("source");
					String dest = rsp.getString("destination");
					op1.println("<tr><td>" + id + "</td><td>" +src+ "</td><td>" + dest + "</td></tr>");
				
				}
				op1.println("</table>");  
	            op1.println("</html></body>"); 
	            
	           
	            
	            op1.println("</form>");
					
					
				
				
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
		
		 
		System.out.println(update1);
	}

}

