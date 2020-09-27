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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		PrintWriter op2 = response.getWriter();
		String fullname  = request.getParameter("fname");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		
		ResultSet rsp = null;		
		Connection connection=null;
		try {
			int rowsInsertCount = 0;
			

			String insertdata = "insert into booked values(?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","root");
			PreparedStatement psp = connection.prepareStatement(insertdata);

			//System.out.println(fullname+" "+age);
			op2.write("<h1>Hello</h1>");
			psp.setString(1,fullname);
			psp.setInt(2,age);
			psp.setString(3,gender);
			

			 int affectedRows = psp.executeUpdate();
			 if(affectedRows>0)
			 {
				 RequestDispatcher df = request.getRequestDispatcher("Flight.html");
					df.forward(request, response);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		
	}
	

}

