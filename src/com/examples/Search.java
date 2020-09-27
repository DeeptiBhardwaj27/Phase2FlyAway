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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter op1 = response.getWriter();
		String source  = request.getParameter("source");
		String destination = request.getParameter("desti");
		int n = Integer.parseInt(request.getParameter("persons"));
		
		ResultSet rsp = null;		
		Connection connection=null;
		
		try {
			String retrievedata ="select * from planes where source=? and destination=?";
			  Class.forName("com.mysql.jdbc.Driver");
			  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","root");
			PreparedStatement psp = connection.prepareStatement(retrievedata);
			psp.setString(1,source);
			psp.setString(2,destination);
			System.out.println(source);
			rsp = psp.executeQuery();
			op1.println("<form action=Register.html method=post>");
			 op1.println("<table border=1 width=100%>");
			 op1.println("<tr><th>SELECT</th><th>flights Number</th><th>Source</th><th>Destination</th><th>Price</th><tr>"); 
			
		
			while(rsp.next()) {
				int id = rsp.getInt("id");
				int price = rsp.getInt("price");
				String src = rsp.getString("source");
				String dest = rsp.getString("destination");
				op1.println("<tr><td><input type=submit name="+id+" value=book ></td><td>" + id + "</td><td>" +src+ "</td><td>" + dest + "</td><td>" + price + "</td></tr>");
			
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

}
