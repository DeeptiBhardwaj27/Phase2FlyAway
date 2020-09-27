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
 * Servlet implementation class pass
 */
@WebServlet("/pass")
public class pass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pass() {
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
		String pass1  = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		
		ResultSet rsp = null;		
		Connection connection=null;
		try {
			int rowsInsertCount = 0;
			

			String insertdata = "update login set pass=? where pass=? ";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","root");
			PreparedStatement psp = connection.prepareStatement(insertdata);

			//System.out.println(fullname+" "+age);
			
			psp.setString(1,pass2);
			psp.setString(2,pass1);
			

			 int affectedRows = psp.executeUpdate();
			 if(affectedRows>0)
			 {
				 RequestDispatcher df = request.getRequestDispatcher("loaded.html");
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


