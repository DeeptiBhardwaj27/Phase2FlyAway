package com.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDetails;

/**
 * Servlet implementation class admin1
 */
@WebServlet("/admin1")
public class admin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin1() {
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
		PrintWriter op = response.getWriter();
		String name1 = request.getParameter("name1");
		String pass1 = request.getParameter("pass1");
		
		
		
		//LoginDetails.validate1(name1, pass);
		if(LoginDetails.validate1(name1,pass1))
		{
			System.out.println("ALL WORKING");
			RequestDispatcher df = request.getRequestDispatcher("Select.html");
			df.forward(request, response);
			 //op.write("<h1>Login Successful</h1>");
		}
		else
		{
			op.write("Login Unsuccesful");
		RequestDispatcher df = request.getRequestDispatcher("admin.html");
		df.include(request, response);
		}
	}

}
